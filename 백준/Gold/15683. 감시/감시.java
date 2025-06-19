import java.io.BufferedReader;
import java.io.IOException;   
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CCTV{
	int x;
	int y;
	int num;
	List<Integer> dirs=new ArrayList<>();
	
	CCTV(int x, int y, int num){
		this.x=x;
		this.y=y;
		this.num=num;
	}
	
	public void addDir(int dir) {
		dirs.add(dir);
	}
}
public class Main {

	static int[][] room;
	static int n,m;
	static List<CCTV> list;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int min=Integer.MAX_VALUE;
	static int area;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		room=new int[n][m];
		list=new ArrayList<CCTV>();
		area=0;
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
				if(room[i][j]==0) area++;
				if(room[i][j]!=0&&room[i][j]!=6) {
					list.add(new CCTV(i, j, room[i][j]));
				}
			}
			
		}
		dfs(0,new CCTV[list.size()]);
		System.out.println(min);
	}
	
	public static void dfs(int depth, CCTV[] cctvs) {
		if(depth==list.size()) {
			countArea(cctvs, new boolean[n][m]);
			return;
		}
		CCTV selected=list.get(depth);
		for(int i=0; i<4; i++) {
			CCTV c=new CCTV(selected.x, selected.y, selected.num);
			switch(c.num) {
				case 1:
					c.addDir(i);
					cctvs[depth]=c;
					dfs(depth+1,cctvs);
					break;
				case 2:
					if(i>=2) return;
					c.addDir(i);
					c.addDir(i+2);
					cctvs[depth]=c;
					dfs(depth+1,cctvs);
					break;
				case 3:
					c.addDir(i);
					c.addDir((i+1)%4);
					cctvs[depth]=c;
					dfs(depth+1,cctvs);
					break;
				case 4:
					c.addDir(i);
					c.addDir((i+1)%4);
					c.addDir((i+2)%4);
					cctvs[depth]=c;
					dfs(depth+1,cctvs);
					break;
				case 5:
					if(i>0) return;
					c.addDir(i);
					c.addDir((i+1)%4);
					c.addDir((i+2)%4);
					c.addDir((i+3)%4);
					cctvs[depth]=c;
					dfs(depth+1,cctvs);
					break;
			}
		}
	}
	
	public static void countArea(CCTV[] cctvs, boolean[][] visited) {
		int cnt=0;
		for(int i=0; i<cctvs.length;i++) {
			CCTV c=cctvs[i];
			for(int j=0; j<c.dirs.size();j++) {
				int dir=c.dirs.get(j);
				int nx=c.x+dx[dir];
				int ny=c.y+dy[dir];
				while(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(room[nx][ny]==0) {
						if(!visited[nx][ny]) {
							cnt++;
							visited[nx][ny]=true;
						}
					}
					else if(room[nx][ny]==6) break;
					nx+=dx[dir];
					ny+=dy[dir];
				}
			}
		}
		min=Math.min(min, area-cnt);
	}
	
	

}