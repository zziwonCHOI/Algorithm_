import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n,m;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] arr;

    static int maxSafeZone=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);

        System.out.println(maxSafeZone);
    }

    public static void dfs(int wallCnt){
        if(wallCnt==3){
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    dfs(wallCnt+1);
                    arr[i][j]=0;
                }
            }
        }

    }

    public static void bfs(){
        Queue<Node> q=new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==2){
                    q.add(new Node(i,j));
                }
            }
        }

        int[][] copy=new int[n][m];
        for(int i=0; i<n; i++){
            copy[i]=arr[i].clone();
        }

        while(!q.isEmpty()){
            Node cur=q.poll();
            int x=cur.x;
            int y=cur.y;
            for(int k=0; k<4; k++){
                int nx=x+dx[k];
                int ny=y+dy[k];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;

                //빈칸인 경우에 바이러스를 퍼뜨린다.
                if(copy[nx][ny]==0){
                    q.add(new Node(nx,ny));
                    copy[nx][ny]=2;
                }
            }
        }

        safeZoneCheck(copy);
    }

    public static void safeZoneCheck(int[][] copyArr) {
        int safe = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0) {
                    safe++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safe);
    }
   static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
   }
}


