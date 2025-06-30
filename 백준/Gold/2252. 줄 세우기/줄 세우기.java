import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Line{
		int v;
		Line e;
		public Line(int f, Line list ){
			v=f;
			e=list;
		}
	}
	
	static Line[] nums;
	static int[] degree;
	static int n,m;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		n=Integer.parseInt(st.nextToken()); //학생수
		m=Integer.parseInt(st.nextToken());//키 비교 횟수 
		nums=new Line[n+1];
		degree=new int[n+1];
		for(int i=0;i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			nums[a]=new Line(b, nums[a]);
			degree[b]++;
			
		}
        
		List<Integer> result=orderCheck();
		if(result.size()==n) {
			for(int i:result) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
		
	}
	public static List<Integer> orderCheck(){
		
		List<Integer> r=new LinkedList<Integer>();
		Queue<Integer> q=new ArrayDeque<Integer>();
		
		//차수가 0인 모든 노드들 큐에 넣기 
		for(int i=1; i<=n; i++) {
			if(degree[i]==0) {
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			Integer cur=q.poll();
			r.add(cur);
			for(Line temp=nums[cur]; temp!=null;temp=temp.e) {
				if(--degree[temp.v]==0) {
					q.offer(temp.v);
				}
			}
		}
		return r;
	}

}