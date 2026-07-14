import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        
        for(int i=0; i<n; i++){
           if(!visited[i]){
               dfs(i,computers,n);
               answer++;
           }
        }
        return answer;
    }
    
    public static void dfs(int curi,int[][] computers,int n){
    
        visited[curi]=true;
        
        for(int i=0; i<n; i++){
            if(!visited[i]&&computers[curi][i]==1){
                dfs(i,computers,n);
            }
        }
    }
}