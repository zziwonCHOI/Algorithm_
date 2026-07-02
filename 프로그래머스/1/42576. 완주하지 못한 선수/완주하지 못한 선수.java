import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> players=new HashMap<String, Integer>();
        
        for(int i=0; i<participant.length; i++){
            String name=participant[i];
            players.put(name,players.getOrDefault(name,0)+1);
        }
        
        for(int i=0; i<completion.length; i++){
            String completeName=completion[i];
            if(players.get(completeName)>1){
                players.put(completeName,players.get(completeName)-1);
            }else{
                players.remove(completeName);
            }
        }
        
        for(String p:players.keySet()){
            answer=p;
        }
        return answer;
    }
}