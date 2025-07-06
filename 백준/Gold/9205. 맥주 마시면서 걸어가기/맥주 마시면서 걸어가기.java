import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static int n;
	static int sx,sy,dx,dy;
	static ArrayList<Store> store;
	
	static class Store{
		int x,y;
		
		public Store(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			n=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			sx=Integer.parseInt(st.nextToken());
			sy=Integer.parseInt(st.nextToken()); 
			
			store=new ArrayList<>();
			
			for(int i=1; i<=n; i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				store.add(new Store(x, y));
			}
			st=new StringTokenizer(br.readLine());
			dx=Integer.parseInt(st.nextToken());
			dy=Integer.parseInt(st.nextToken());
			
			System.out.println(bfs()?"happy":"sad");
		}
	}

    
	public static boolean bfs() {
		Queue<int[]> q=new LinkedList<int[]>();
		q.offer(new int[] {sx,sy});
		boolean[] visited=new boolean[store.size()];
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int nx=cur[0];
			int ny=cur[1];
			
			long festD=Math.abs(dx-nx)+Math.abs(dy-ny);
			if(festD<=1000) return true;
			
			//현재 거리에서 참여 불가능하다면 편의점 탐색 
			for(int i=0; i<store.size();i++) {
				Store nextStore=store.get(i);
				long storeD=Math.abs(nextStore.x-nx)+Math.abs(nextStore.y-ny);
				
				if(!visited[i]&&storeD<=1000) {
					q.offer(new int[] {nextStore.x,nextStore.y});
					visited[i]=true;
				}
			}
		}
        
		return false;
	}
}