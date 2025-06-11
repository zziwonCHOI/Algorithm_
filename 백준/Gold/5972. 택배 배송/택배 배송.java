import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static ArrayList<int[]>[] list;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }

        d=new int[n+1];
        for(int i=1; i<=n; i++){
            d[i]=Integer.MAX_VALUE;
        }

        solve();
        System.out.println(d[n]);
    }

    public static void solve(){
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(o->o[0]));
        pq.add(new int[]{0,1});
        d[1]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cost=cur[0];
            int now=cur[1];

            if(cost>d[now]) continue;

            for(int[] next:list[now]){
                if(d[next[0]]>cost+next[1]){
                    d[next[0]]=cost+next[1];
                    pq.offer(new int[]{d[next[0]],next[0]});
                }
            }
        }
    }
}