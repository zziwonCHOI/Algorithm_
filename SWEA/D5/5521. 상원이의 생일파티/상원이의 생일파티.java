import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static int[][] friend;
	static int cnt;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			friend = new int[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				friend[a][b] = 1;
				friend[b][a] = 1;

			}

			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				if (friend[1][i] != 0) {
					list.add(i);
				}
			}
			cnt = 0;
			visited = new boolean[n + 1];
			bfs(list);
			System.out.println("#" + t + " " + cnt);
		}
	}

	public static void bfs(ArrayList<Integer> l) {
		visited[1] = true;
		Queue<int[]> q = new LinkedList<>();
		for (int i : l) {
			q.add(new int[] { i, 1 });
			visited[i] = true;
			cnt++;
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cNum = cur[0];
			int d = cur[1];

			if (d == 2)
				continue;

			for (int i = 1; i <= n; i++) {
				if (!visited[i] && friend[cNum][i] == 1) {
					visited[i] = true;
					q.add(new int[] { i, d + 1 });
					cnt++;
				}
			}

		}

	}
}