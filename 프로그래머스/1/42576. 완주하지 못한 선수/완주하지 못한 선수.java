import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map=new HashMap<>();
        int n=participant.length;
        
        for(int i=0 ;i<n; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0 ;i<completion.length; i++){
            String cur=completion[i];
            map.put(cur,map.get(cur)-1);
        }
        
        for(String s:map.keySet()){
            if(map.get(s)>=1){
                answer=s;
            }
        }
        return answer;
    }
}