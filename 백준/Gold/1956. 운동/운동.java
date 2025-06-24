import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int INF=100000000;
        int[][] dist=new int[v+1][v+1];
        for(int i=1; i<=v; i++){
            Arrays.fill(dist[i],INF);
        }
        for(int i=0; i<e; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            dist[a][b]=c;
        }

        for(int k=1; k<=v; k++){
            for(int i=1; i<=v; i++){
                for(int j=1; j<=v; j++){
                    if(dist[i][k]!=INF&&dist[k][j]!=INF){
                        if(dist[i][k]+dist[k][j]<dist[i][j]){
                            dist[i][j]=dist[i][k]+dist[k][j];
                        }
                    }
                }
            }
        }

        int result=INF;
        for(int i=1; i<=v; i++){
            result=Math.min(result,dist[i][i]); //자기 자신으로돌아오는 경로
        }

        System.out.println(result==INF?-1:result);
    }
}