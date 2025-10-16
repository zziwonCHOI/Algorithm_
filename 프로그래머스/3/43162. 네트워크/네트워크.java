class Solution {

    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,n, computers);
                answer+=1;
            }
        }
        return answer;
    }
    
    public static void dfs(int node, int n, int[][] computers){
        visited[node]=true;
        
        for(int i=0;i<n; i++){
            if(!visited[i]&&computers[node][i]==1){
                dfs(i,n,computers);
            }
        }
    }
}