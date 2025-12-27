import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int missileCount = 0;
        double lastInterceptX = -1;

        for (int[] target : targets) {
            int startX = target[0];
            int endX = target[1];

            if (lastInterceptX <= startX) {
                missileCount++;
                lastInterceptX = endX - 0.5;
            }
        }

        return missileCount;
    }
}
