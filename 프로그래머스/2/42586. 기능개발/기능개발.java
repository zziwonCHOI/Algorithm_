import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer=new LinkedList<>();
        int n=progresses.length;
                
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<n; i++){
            int spendTime=100-progresses[i];
            if(spendTime%speeds[i]!=0){
                spendTime=spendTime/speeds[i]+1;
            }else{
                spendTime/=speeds[i];
            }
            q.add(spendTime);
        }
        
        while(!q.isEmpty()){
            int cur=q.poll();
            int oneDaySuccess=1;
            while(!q.isEmpty()&&q.peek()<=cur){
               oneDaySuccess++;
               q.poll();
            }
            answer.add(oneDaySuccess);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}