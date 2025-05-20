import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] prices;
	static int[] plan;
	static int minPrice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			prices = new int[4];
			plan = new int[12];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			minPrice = prices[3];
			calPrice(0, 0);
			System.out.println("#" + t + " " + minPrice);
		}
	}

	private static void calPrice(int sum, int month) {
		if (month >= 12) {
			minPrice = Math.min(minPrice, sum);
			return;
		}

		if (plan[month] == 0) {
			calPrice(sum, month + 1);
		} else {
			calPrice(sum + prices[0] * plan[month], month + 1);
			calPrice(sum + prices[1], month + 1);
			calPrice(sum + prices[2], month + 3);
		}
	}

}