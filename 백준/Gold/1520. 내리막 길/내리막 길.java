import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map,dp;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static long totalCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		dp=new int[n][m];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		totalCnt=0;
	
		System.out.println(dfs(0,0));
	}

	public static int dfs(int x, int y) {
		if(x==n-1&&y==m-1) {
			return 1;
		}
		if(dp[x][y]!=-1) return dp[x][y];
		dp[x][y]=0;
		for(int k=0; k<4; k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			if(map[x][y]<=map[nx][ny]) continue;
			
			dp[x][y]+=dfs(nx,ny);
		}
		return dp[x][y];
	}
}