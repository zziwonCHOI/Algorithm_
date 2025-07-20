import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;  


public class Main {

	static int r,c;
	static int[] dy= {1,1,1};
	static int[] dx= {-1,0,1};
	static char[][] map;
	static int cnt;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		map=new char[r][c];
		for(int i=0; i<r;i++) {
			String line=br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j]=line.charAt(j);
			}
		}
		visited=new boolean[r][c];
		cnt=0;
		for(int i=0; i<r; i++) {
			if(dfs(i, 0)) {
				cnt+=1;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static boolean dfs(int x, int y) {
		visited[x][y]=true;
		for(int i=0; i<3; i++) {
			int curx=x+dx[i];
			int cury=y+dy[i];
			
			if(curx<0||cury<0||curx>=r|| cury>=c) continue;
			
			if(cury==c-1) {
				return true;
			}
			if(!visited[curx][cury]&&map[curx][cury]!='x') {
				visited[curx][cury]=true;
				if(dfs(curx,cury)) {
					return true;
				}
			}
		}
		return false;
	}

}