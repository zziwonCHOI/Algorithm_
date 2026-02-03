import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        String[] t=today.split("\\.");
        int year=Integer.parseInt(t[0]);
        int month=Integer.parseInt(t[1]);
        int day=Integer.parseInt(t[2]);
        Map<String, Integer> map=new HashMap<>();
        

        for(String ter:terms){
            String[] s=ter.split(" ");
            map.put(s[0],Integer.parseInt(s[1]));
        }
        
        int idx=0;
        for(int i=0; i<privacies.length; i++){
            String[] s=privacies[i].split(" ");
            String[] date=s[0].split("\\.");
            
            int limit=map.get(s[1]);
            int y=Integer.parseInt(date[0]);
            int m=Integer.parseInt(date[1]);
            int d=Integer.parseInt(date[2]);
            
            m+=limit;
            y+=(m-1)/12;
            m=(m-1)%12+1;
            
            d-=1;
            if(d==0){
                d=28;
                m-=1;
                if(m==0){
                    m=12;
                    y-=1;
                }
            }
           
            if(year>y || (year==y&&month>m)||(year==y&&month==m&&day>d)){
                answer[idx++]=i+1;
            }
        }
        return Arrays.copyOf(answer,idx);
    }
}