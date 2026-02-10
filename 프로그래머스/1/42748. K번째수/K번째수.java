import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx=0;
        for(int i=0; i<commands.length; i++){
            int start=commands[i][0];
            int end=commands[i][1];
            int target=commands[i][2];
            
            int[] arr=new int[end-start+1]; 
            int q=0;
            for(int j=start-1; j<end; j++){
                arr[q++]=array[j];
            }
            Arrays.sort(arr);
            answer[idx++]=arr[target-1];
        }
        return answer;
    }
}