import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String,Integer> playerMap=new HashMap<>();
        Map<Integer,String> rankMap=new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            playerMap.put(players[i],i+1);
            rankMap.put(i+1,players[i]);
        }
        
        for(int i=0; i<callings.length; i++){
            String callName=callings[i];
            int curRank=playerMap.get(callName);
            String beforePlayerName=rankMap.get(curRank-1);
            playerMap.put(callName,curRank-1);
            playerMap.put(beforePlayerName,curRank);
            rankMap.put(curRank,beforePlayerName);
            rankMap.put(curRank-1,callName);
        }
        
        String[] answer=new String[players.length];
        for(int i=0; i<players.length; i++){
            answer[i]=rankMap.get(i+1);
        }
        
        return answer;
    }
}