import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int v, e;
	static int[] parent;
	static int[] d;

	static class Edge implements Comparable<Edge> {
		int to, from, cost;

		public Edge(int to, int from, int cost) {
			this.to = to;
			this.from = from;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new Edge(a - 1, b - 1, c));
			}
			
			makeset();
			long sum=0L;
			while(!pq.isEmpty()) {
				Edge cur=pq.poll();
				if(!isConnected(cur.to, cur.from)) {
					union(cur.from, cur.to);
					sum+=cur.cost;
				}
			}
			System.out.println("#"+t+" "+sum);
		}

	}

	public static boolean isConnected(int a, int b) {
		if(find(a)==find(b)) {
			return true;
		}
		return false;
	}
	public static void union(int a, int b) {
		int aP=find(a);
		int bP=find(b);
		if(a==b) return;
		
		if(d[aP]>=d[bP]) {
			parent[bP]=aP;
			d[aP]+=d[bP];
		}else {
			parent[aP]=bP;
			d[bP]+=d[aP];
		}
	}
	
	public static int find(int a) {
		if(a==parent[a]) return a;
		
		return parent[a]=find(parent[a]);
	}
	public static void makeset() {
		parent=new int[v];
		for(int i=0; i<v; i++) {
			parent[i]=i;
		}
		d=new int[v];
		for(int i=0; i<v; i++) {
			d[i]=1;
		}
	}
}