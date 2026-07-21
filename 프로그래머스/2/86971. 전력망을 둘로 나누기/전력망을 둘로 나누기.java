import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static int cnt;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph=new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[] wire:wires){
            int a=wire[0];
            int b=wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int[] wire:wires){
            visited=new boolean[n+1];
            cnt=0;
            dfs(1,wire[0],wire[1]);
            int diff=Math.abs((n-cnt)-cnt);
            answer=Math.min(diff,answer);
        }
        return answer;
    }
    
    public static void dfs(int cur, int a,int b){
        visited[cur]=true;
        cnt++;
        
        for(int next:graph[cur]){
            if((cur==a&&next==b)||(cur==b&&next==a)) continue;
            if(!visited[next]){
                dfs(next,a,b);
            }
        }
    }
}