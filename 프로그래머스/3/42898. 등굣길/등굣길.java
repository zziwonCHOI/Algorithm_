import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n][m];
        boolean[][] isPuddles = new boolean[n][m];
        
        for (int[] p : puddles) {
            int x = p[0] - 1;
            int y = p[1] - 1;
            isPuddles[y][x] = true;  
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {        
            for (int j = 0; j < m; j++) {   
                if (isPuddles[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0) dp[i][j] += dp[i - 1][j] % MOD; // 위쪽
                if (j > 0) dp[i][j] += dp[i][j - 1] % MOD; // 왼쪽
                dp[i][j] %= MOD;
            }
        }

        return dp[n - 1][m - 1];
    }
}
