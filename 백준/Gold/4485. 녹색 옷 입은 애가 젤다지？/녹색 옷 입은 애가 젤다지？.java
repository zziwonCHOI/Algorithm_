import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static final int INF = 999999;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=1;

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			int minLost = 0;
			boolean[][] visited = new boolean[n][n];
			int[][] distance = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(distance[i], INF);
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1[2], o2[2]);
				}
			});

			distance[0][0] = arr[0][0];
			pq.offer(new int[] {0,0,arr[0][0]});
			
			while(!pq.isEmpty()) {
				int[] cur=pq.poll();
				int x=cur[0];
				int y=cur[1];
				int cost=cur[2];
				
				if(visited[x][y]) continue;
				visited[x][y]=true;
				
				
				for(int i=0; i<4; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					
					if(nx>=0&&ny>=0&&nx<n&&ny<n) {
						int newCost=arr[nx][ny]+cost;
						if(newCost<distance[nx][ny]) {
							distance[nx][ny]=newCost;
							pq.offer(new int[] {nx,ny,newCost});
						}
					}
				}
			}
			System.out.println("Problem "+tc+": "+distance[n-1][n-1]);
			tc++;

		}

	}

}