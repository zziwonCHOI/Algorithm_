import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q=new LinkedList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            q.add(new int[]{priorities[i],i});
            pq.add(priorities[i]);
        }
        int i=0;
        while(true){
            if(q.isEmpty()) break;
            int[] cur=q.poll();
            if(cur[0]==pq.peek()){
                pq.poll();
                i++;
                if(cur[1]==location){
                    answer=i;
                    break;
                }
            }else{
                q.add(cur);
            }
        }
        return answer;
    }
}