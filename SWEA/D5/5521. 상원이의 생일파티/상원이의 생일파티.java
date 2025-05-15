import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n,m;
    static ArrayList<ArrayList<Integer>> list;
    static Queue<int[]> search;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            list=new ArrayList<>();
            for(int i=0; i<=n; i++){
                list.add(new ArrayList<>());
            }

            search=new LinkedList<>();
            visited=new boolean[n+1];
            visited[1]=true;
            for(int i=0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);

            }
            for(int friend:list.get(1)){
                search.add(new int[]{friend,1});
                visited[friend]=true;
            }

           result=0;
            bfs();
            System.out.println("#"+t+" "+result);
        }
    }

    public static void bfs(){
        while(!search.isEmpty()){
            int[] cur=search.poll();
            int num=cur[0];
            int depth=cur[1];
            result++;
            if(depth==2) continue;


            for(int next:  list.get(num)){
               if(!visited[next]){
                   visited[next]=true;
                   search.add(new int[]{next,depth+1});
               }
            }

        }
    }
}