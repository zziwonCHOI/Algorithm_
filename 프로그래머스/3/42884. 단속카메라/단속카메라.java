import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        //나가는 지점으로 정렬
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        
        int cur=routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][0]>cur){
                cur=routes[i][1];
                answer+=1;
            }
        }
        return answer;
    }
}