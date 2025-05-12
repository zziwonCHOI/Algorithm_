import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static char[][] arr;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int nomalGroup;
	static int specialGroup;
	static boolean[][] visitedN;
	static boolean[][] visitedS;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		arr=new char[n][n];
		for(int i=0; i<n; i++) {
			char[] line=br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				arr[i][j]=line[j];
			}
		}
		nomalGroup=0;
		specialGroup=0;
		
		visitedN=new boolean[n][n];
		visitedS=new boolean[n][n];

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visitedN[i][j]) {
					nomalGroup++;
					bfs(i,j);
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visitedS[i][j]) {
					specialGroup++;
					bfs2(i,j,arr[i][j]);
				}
			}
		}
		System.out.println(nomalGroup+" "+specialGroup);
		
	}

	public static void bfs2(int x,int y, char color) {
		Queue<int[]> q=new LinkedList<int[]>();
		visitedS[x][y]=true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			for(int k=0; k<4; k++) {
				int nx=cur[0]+dx[k];
				int ny=cur[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				if(color=='R'||color=='G') {
					if(arr[nx][ny]=='B') continue;
				}else if(color!=arr[nx][ny]) continue;
				
				if(!visitedS[nx][ny]) {
					visitedS[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	public static void bfs(int x,int y) {
		Queue<int[]> q=new LinkedList<int[]>();
		visitedN[x][y]=true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			for(int k=0; k<4; k++) {
				int nx=cur[0]+dx[k];
				int ny=cur[1]+dy[k];
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				if(arr[nx][ny]!=arr[x][y]) continue;
				
				if(!visitedN[nx][ny]) {
					visitedN[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
}