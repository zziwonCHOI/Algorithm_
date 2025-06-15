import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 앱 개수
        int M = Integer.parseInt(st.nextToken()); // 확보해야 하는 메모리 크기

        int[] memory = new int[N]; // 각 앱이 사용하는 메모리
        int[] cost = new int[N];   // 각 앱을 비활성화할 때 드는 비용

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minimumCost(N, M, memory, cost));
    }

    public static int minimumCost(int N, int M, int[] memory, int[] cost) {
        int maxCost = 100 * N; // 최대 비용 (앱 100개, 비용 최대 100)
        int[] dp = new int[maxCost + 1]; // dp[j]: 비용 j에서 얻을 수 있는 최대 메모리

        // DP 실행 (배낭 문제 방식, 비용이 무게, 메모리가 가치)
        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= cost[i]; j--) { // 뒤에서부터 갱신
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        // 최소 비용 찾기 (dp[j] >= M이 되는 최소 j)
        for (int j = 0; j <= maxCost; j++) {
            if (dp[j] >= M) return j;
        }

        return -1; // 이론적으로는 도달할 수 없는 경우 (문제에서 M ≤ 전체 메모리 보장)
    }
}