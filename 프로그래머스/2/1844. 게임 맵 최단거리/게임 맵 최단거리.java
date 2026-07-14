import java.util.*;

class Solution {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    
    public int solution(int[][] maps) {
        
        int n=maps.length;
        int m=maps[0].length;
        
        int answer= bfs(maps, n,m);
        return answer;
    }
    
    public static int bfs(int[][] maps, int n, int m){
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        visited[0][0]=true;
        q.add(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==n-1&&cur[1]==m-1) return cur[2];
            for(int k=0; k<4; k++){
                int nx=cur[0]+dx[k];
                int ny=cur[1]+dy[k];
                
                if(nx<0||ny<0|nx>=n||ny>=m) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny]==0) continue;
                
                visited[nx][ny]=true;
                q.add(new int[]{nx,ny,cur[2]+1});
                
            }
        }
        return -1;
    }
}