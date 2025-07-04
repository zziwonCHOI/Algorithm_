import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Main {

	static char[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int r, c; 
	static Set<Character> check = new HashSet<>();
	static int maxCnt = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");
		r = Integer.parseInt(nums[0]);
		c = Integer.parseInt(nums[1]);

        
		arr = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		dfs(0, 0, 1);
		System.out.println(maxCnt);

	}

	public static void dfs(int x, int y, int d) {
		check.add(arr[x][y]);
		maxCnt = Math.max(maxCnt, d);
		for (int k = 0; k < 4; k++) {
			int X = x + dx[k];
			int Y = y + dy[k];
			if (X >= 0 && Y >= 0 && X < r && Y < c && !check.contains(arr[X][Y])) {
				dfs(X, Y, d+1); 
			}

		}
		check.remove(arr[x][y]);
	}

}