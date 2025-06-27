import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//모든 가능한 상태를 한 번씩만 방문하며 정답이 존제하는지를 탐색해야 한다. -> bfs 사용
public class Main {
    static int x,y,z;
    static boolean[][] visited;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        z=Integer.parseInt(st.nextToken());

        visited=new boolean[1501][1501];
        total=x+y+z;

        if(total%3!=0) {
            System.out.println(0);
            return;
        }
        bfs(x,y,z);

    }

    private static void bfs(int x, int y, int z) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int a=cur[0];
            int b=cur[1];
            int c=total-a-b;

            if(a==b&&b==c){
                System.out.println(1);
                return;
            }

            int[] arr={a,b,c};
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==j) continue;

                    if(arr[i]<arr[j]){
                        int[] next=arr.clone();
                        next[i]=arr[i]+arr[i];
                        next[j]=arr[j]-arr[i];

                        int nx=next[0], ny=next[1], nz=next[2];
                        int[] sorted={nx,ny,nz};
                        Arrays.sort(sorted);
                        
                        //중복 상태 방지
                        if(!visited[sorted[0]][sorted[1]]){
                            visited[sorted[0]][sorted[1]]=true;
                            q.add(new int[]{sorted[0],sorted[1]});
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

}