import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//1. 모든 구엽을 a,b 그룹으로 나눈다.(subset)
//2. 각 그룹이 연결되어 있어야 한다. (bfs)
//3. 연결되어 있다면 두 그룹의 인구 차이의 최소값을 계산한다. 
//4. 가능한 모든 경우를 검사한 후, 최소 차이를 출력한다. 
public class Main {
	static int n;
	static int[] people;
	static List<Integer>[] adj; //각 구역의 인접 구역 리스트 
	static boolean[] selected; //true면 A 그룹, false면 B 그룹
	static int minDiff;// 최소 인구 차이 저장 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		people = new int[n];
		st = new StringTokenizer(br.readLine());
		adj=new ArrayList[n]; //인접 리스트 초기화 
		
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			adj[i] = new ArrayList<Integer>();
		}

		//인접 구역 정보 입력 받기 
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); //연결된 구역의 수 
			for (int j = 0; j < cnt; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()) - 1); //인덱스 형태로 저장 
				//i 구역에 인접한 구역 입력 받아 저장 
			}
		}
		selected = new boolean[n];
		minDiff=Integer.MAX_VALUE;
		subset(0);
		
		System.out.println(minDiff==Integer.MAX_VALUE?-1:minDiff);

	}

	private static void subset(int cnt) {
		if (cnt == n) {
			List<Integer> aG = new ArrayList<Integer>(); //A 그룹
			List<Integer> bG = new ArrayList<Integer>(); //B 그룹 

			//선택된 구역을 A/B로 나누기 
			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					aG.add(i);
				} else {
					bG.add(i);
				}
				

			}
			// 둘 중 하나라도 비어있으면 안됨 (불가능한 그룹)
			if (aG.size() == 0 || bG.size() == 0)
				return;

			//두 그룹 모두 그룹 형태인지 확인 (각각 덩어리인지 확인)
			if (isConnected(aG) && isConnected(bG)) {
				int aSum = 0;
				int bSum = 0;
				//각 그룹의 인구 수 합 구하기 
				for (int a : aG)
					aSum += people[a];
				for (int b : bG)
					bSum += people[b];
				minDiff = Math.min(minDiff, Math.abs(aSum - bSum));
			}

			return;
		}

		//현재 구역을 A그룹에 넣는 경우
		selected[cnt] = true;
		subset(cnt + 1);
		//현재 구역을 b 그룹에 넣는 경우 
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
				//다음 정점이 방문하지 않았고, 같은 그룹에 속할 때만 이동 
				if(!visited[next]&&group.contains(next)) {
					visited[next]=true;
					q.add(next);
					count++;
				}
			}
		}
		//BFS로 방문한 노드의 수==그룹 크기인 경우 그룹이다. 
		return count==group.size();
	}

}