import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static class Edge{
        int to, value;
        public Edge(int to, int value){
            this.to=to;
            this.value=value;
        }
    }
    static ArrayList<Edge>[] list;
    static int start, end;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());

        list=new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
        }

        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end= Integer.parseInt(st.nextToken());

        result=dijkstra();
        System.out.print(result);
    }

    private static int dijkstra() {
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparing(a->a[0]));
        pq.offer(new int[]{0,start});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cost=cur[0];
            int t=cur[1];

            if(cost>dist[t]) continue;
            if(t==end) break;

            for(Edge e:list[t]){
                int v=e.to;
                int nc=cost+e.value;
                if(dist[v]>nc){
                    dist[v]=nc;
                    pq.offer(new int[]{nc,v});
                }
            }
        }
        return dist[end];
    }
}
