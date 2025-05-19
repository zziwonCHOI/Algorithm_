import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int a,b,c;
		public Edge(int a, int b, int c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
		@Override
		public int compareTo(Edge o) {
			return this.c-o.c;
		}
		
	}
	static int v,e;
	static int[] parent;
	static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		for(int i=0; i<e; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			pq.add(new Edge(a-1, b-1, c));
		}
		makeSet();
		long sum=0L;
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
			//합쳐져 있지 않다면 
			if(!isConnect(cur.a,cur.b)) {
				union(cur.a,cur.b);
				sum+=cur.c;
			}
		} 
		System.out.println(sum);
	}
	private static boolean isConnect(int a, int b) {
		if(find(a)==find(b)) {
			return true;
		}
		return false;
	}
	private static void union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		if(pa==pb) return;
		
		if(d[pa]>=d[pb]) {
			parent[pb]=pa;
			d[pa]+=d[pb];
		}else {
			parent[pa]=pb;
			d[pb]+=d[pa];
		}
		
	}
	private static int find(int a) {
		if(a==parent[a]) {
			return parent[a];
		}else {
			return parent[a]=find(parent[a]);
		}
	}
	private static void makeSet() {
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