import java.util.*;

class Solution {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n=maps.length;
        int m=maps[0].length;
        visited=new boolean[n][m];
        answer=bfs(maps,n,m);
        return answer;
    }
    
    public static int bfs(int[][] maps,int n, int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int k=0; k<4; k++){
                int nx=dx[k]+cur[0];
                int ny=dy[k]+cur[1];
                if(nx<0||ny<0||nx>=n||ny>=m||maps[nx][ny]==0) continue;
                if(visited[nx][ny]) continue;
                
                if(nx==n-1&&ny==m-1){
                    return cur[2]+1;
                }
                visited[nx][ny]=true;
                q.add(new int[]{nx,ny,cur[2]+1});
            }
        }
        return -1;
    }
}