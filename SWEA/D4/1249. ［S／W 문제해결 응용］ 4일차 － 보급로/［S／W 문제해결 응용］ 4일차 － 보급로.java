import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] dis;
    static class Point implements Comparable<Point>{
        int x, y, d;
        public Point(int x, int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
        @Override
        public int compareTo(Point o) {
            return this.d-o.d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            map=new int[n][n];
            for(int i=0; i<n; i++){
                char[] line=br.readLine().toCharArray();
                for(int j=0; j<n; j++){
                    map[i][j]=line[j]-'0';
                }
            }

            dis=new int[n][n];
            for(int i=0; i<n; i++){
                Arrays.fill(dis[i],Integer.MAX_VALUE);
            }
            int result=bfs();
            System.out.println("#"+t+" "+result);
        }
    }

    public static int bfs(){
        PriorityQueue<Point> pq=new PriorityQueue<>();
        pq.add(new Point(0,0,map[0][0]));
        dis[0][0]=map[0][0];

        while(!pq.isEmpty()){
            Point cur=pq.poll();
            int cx=cur.x;
            int cy=cur.y;
            int d=cur.d;

            for(int k=0; k<4; k++){
                int nx=cx+dx[k];
                int ny=cy+dy[k];

                if(nx<0||ny<0||nx>=n||ny>=n) continue;

                if(dis[nx][ny]>map[nx][ny]+dis[cx][cy]){
                    dis[nx][ny]=map[nx][ny]+dis[cx][cy];
                    pq.add(new Point(nx,ny,dis[nx][ny]));
                }
            }
        }
        return dis[n-1][n-1];
    }
}
//1
//4
//0100
//1110
//1011
//1010