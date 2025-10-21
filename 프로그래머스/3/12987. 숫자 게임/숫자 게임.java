import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        Arrays.sort(A);
        int n=B.length;
        int aIdx=0;
        int bIdx=0;
        
        while(aIdx<n && bIdx<n){
            if(B[bIdx]>A[aIdx]){
                answer++;
                bIdx++;
                aIdx++;
            }else{
                bIdx++;
            }
        }
        return answer;
    }
}