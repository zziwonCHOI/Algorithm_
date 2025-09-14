import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map=new HashMap<>();
        
        for(int t:tangerine){
           map.put(t,map.getOrDefault(t,0)+1);
        }
        
        List<Integer> counts=new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        for(int count:counts){
            k-=count;
            answer++;
            if(k<=0) break;
        }
        return answer;
    }
}