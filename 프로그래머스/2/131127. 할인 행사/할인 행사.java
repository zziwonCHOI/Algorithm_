import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len=discount.length;
        
        for(int i=0; i<=len-10; i++){
            Map<String, Integer> map=new HashMap<>();
            for(int j=i; j<i+10; j++){
                String item = discount[j];
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
         
            if(isSame(map, want,number)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isSame(Map<String, Integer> map, String[] want, int[] number){
        for(int i=0; i<want.length; i++){
            String w=want[i];
            int n= number[i];
            
            if(!map.containsKey(w)) return false;
            
            if(map.get(w)<n) return false;
            
        }
        
        return true;
        
    }
    
}