import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n;i++){
            if(pq.isEmpty()) break;
            
            int max=pq.poll();
            if(max==0) break;
            
            pq.add(max-1);
        }
        
        for(int num:pq){
            answer+=(long)(num*num);
        }
        return answer;
    }
}