import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] people;
	static List<Integer>[] adj;
	static boolean[] selected;
	static int minDiff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		people = new int[n];
		st = new StringTokenizer(br.readLine());
		adj=new ArrayList[n];
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		selected = new boolean[n];
		minDiff=Integer.MAX_VALUE;
		subset(0);
		
		System.out.println(minDiff==Integer.MAX_VALUE?-1:minDiff);

	}

	private static void subset(int cnt) {
		if (cnt == n) {
			List<Integer> aG = new ArrayList<Integer>();
			List<Integer> bG = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					aG.add(i);
				} else {
					bG.add(i);
				}
				

			}
			// 둘 중 하나라도 비어있으면 안됨
			if (aG.size() == 0 || bG.size() == 0)
				return;

			if (isConnected(aG) && isConnected(bG)) {
				int aSum = 0;
				int bSum = 0;
				for (int a : aG)
					aSum += people[a];
				for (int b : bG)
					bSum += people[b];
				minDiff = Math.min(minDiff, Math.abs(aSum - bSum));
			}

			return;
		}

		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);

	}

	private static boolean isConnected(List<Integer> group) {
		boolean[] visited=new boolean[n];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(group.get(0));
		visited[group.get(0)]=true;
		
		int count=1;
		while(!q.isEmpty()) {
			int cur=q.poll();
			//현재 위치의 주변에 있는 곳 방문 
			for(int next:adj[cur]) {
				if(!visited[next]&&group.contains(next)) {
					visited[next]=true;
					q.add(next);
					count++;
				}
			}
		}
		return count==group.size();
	}

}