import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int v,e;
	static int[][] graph;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {

		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		v=Integer.parseInt(br.readLine());
		e=Integer.parseInt(br.readLine());
		
		graph=new int [v+1][v+1];
		
		for(int i=0; i<e; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			
			graph[from][to]=graph[to][from]=1;
		}
		
		visited=new boolean[v+1];
		cnt=0;
		dfs(1);
		
		System.out.println(cnt);
		
	}
	
	public static void dfs(int start) {
		visited[start]=true;
		for(int i=1; i<=v; i++) {
			if(graph[start][i]==1&&!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
	}

}
