import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n,k;
    static int[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int result;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());

            int maxHeight=-1;
            map=new int[n][n];
            for(int i=0; i<n ;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                    maxHeight=Math.max(map[i][j],maxHeight);
                }
            }

            result=Integer.MIN_VALUE;
            visited=new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){

                    if(maxHeight==map[i][j]){
                        visited[i][j]=true;
                        dfs(i,j,1,map[i][j],k);
                        visited[i][j]=false;
                    }
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }

    private static void dfs(int i, int j, int len, int height, int k) {
        result=Math.max(result,len);
        for(int q=0; q<4; q++){
            int nx=i+dx[q];
            int ny=j+dy[q];

            if(nx<0||ny<0||nx>=n||ny>=n||visited[nx][ny]) continue;

            if(k==0){
                if(map[nx][ny]<height){
                    visited[nx][ny]=true;
                    dfs(nx,ny,len+1,map[nx][ny],k);
                    visited[nx][ny]=false;
                }
            }else{
                if(map[nx][ny]<height){
                    visited[nx][ny]=true;
                    dfs(nx,ny,len+1,map[nx][ny],k);
                    visited[nx][ny]=false;
                }else if((map[nx][ny]-k)<height){
                    visited[nx][ny]=true;
                    dfs(nx,ny,len+1,height-1,0);
                    visited[nx][ny]=false;
                }
            }
        }

    }


}