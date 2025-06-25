import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//벨만포드 알고리즘: 음수 간선 존재. 사이클 존재 하는 최단 거리
//입력은 간선 리스트로 받기
public class Main {
    static class Edge{
        int from, to, cost;
        Edge(int f, int t, int c){
            from=f;
            to=t;
            cost=c;
        }
    }
    static int INF=100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        List<Edge> edges=new ArrayList<>();
        for(int i=0; i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }

        //최단 거리 배열 초기화
        long[] dist=new long[n+1];
        Arrays.fill(dist,INF);
        dist[1]=0; //시작점은 1번

        //벨만-포드 알고리즘 수행(n-1번 반복)
        for(int i=1; i<n; i++){
            for(Edge e:edges){
                if(dist[e.from]!=INF&&dist[e.to]>dist[e.from]+e.cost){
                    dist[e.to]=dist[e.from]+e.cost;
                }
            }
        }

        //음수 사이클 검사(한 번 더 반복해서 갱신되면 사이클 존재)
        for(Edge e:edges){
            if(dist[e.from]!=INF&&dist[e.to]>dist[e.from]+e.cost){
                System.out.println(-1);
                return;
            }
        }

        for (int i=2;i<=n; i++){
            System.out.println(dist[i]==INF?-1:dist[i]);
        }
    }
}