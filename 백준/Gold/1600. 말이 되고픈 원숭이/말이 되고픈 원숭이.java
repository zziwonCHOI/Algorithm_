import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k,w,h;
	static int[][] arr;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int[] hx = {1,2,2,1,-1,-2,-2,-1};
	static int[] hy = {2,1,-1,-2,-2,-1,1,2};
	static boolean[][][] visited;
	public static void main(String[] args) throws  IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		k=Integer.parseInt(br.readLine()); //원숭이 이동 횟수(말의 방식으로)
		st=new StringTokenizer(br.readLine());
		
		w=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		arr=new int[h][w];
		
		for(int i=0; i<h; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new boolean[h][w][k+1];
		int result=bfs(0,0);
		
		System.out.println(result);
		
	}
	public static int bfs(int x, int y) {
		Queue<int[]> q=new LinkedList<int[]>();
		visited[x][y][0]=true;
		q.add(new int[] {x,y,0,0});
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int curx=cur[0];
			int cury=cur[1];
			int chance=cur[2];
			int move=cur[3];
			
			if(curx==h-1&&cury==w-1) return move;
			
			for(int i=0; i<4; i++) {
				int nx=curx+dx[i];
				int ny=cury+dy[i];
				
				if(nx<0||ny<0||nx>=h||ny>=w) continue;
				if(visited[nx][ny][chance]) continue;
				
				if(arr[nx][ny]!=1) {
					visited[nx][ny][chance]=true;
					q.add(new int[] {nx,ny,chance,move+1});
					
				}
			}
			
			if(chance<k) {
				for(int i=0; i<8; i++) {
					int nx=curx+hx[i];
					int ny=cury+hy[i];
					
					if(nx<0||ny<0||nx>=h||ny>=w) continue;
					if(visited[nx][ny][chance+1]) continue;
					
					if(arr[nx][ny]!=1) {
						visited[nx][ny][chance+1]=true;
						q.add(new int[] {nx,ny,chance+1,move+1});
						
					}

				}
			}
		}
		return -1;
	}

}