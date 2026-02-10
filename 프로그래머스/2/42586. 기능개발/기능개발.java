import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] answer = new int[n];

        int[] restTime=new int[n];
        for(int i=0; i<n; i++){
            restTime[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }
        
        int idx=0;        
        for(int i=0; i<n; i++){
            int cnt=1;
            boolean flag=false;
            for(int j=i+1; j<n; j++){
                if(restTime[i]>=restTime[j]){
                    cnt++;
                    flag=true;
                }else{
                    break;
                }
            }
            answer[idx++]=cnt;
            if(flag){
                i+=cnt-1;
            }
            
        }
        return Arrays.copyOf(answer,idx);
    }
}