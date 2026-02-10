import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxW=0;
        int maxH=0;
        
        for(int i=0; i<sizes.length; i++){
            //더 큰쪽을 가로로, 더 작은쪽을 세로로 지정
            int w=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            
            maxW=Math.max(w,maxW);
            maxH=Math.max(h,maxH);
        }
        return maxW*maxH;
    }
}