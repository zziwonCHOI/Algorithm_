import java.io.*;
import java.util.*;

public class Main {

    static class Ball {
        int idx, color, size;
        Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
        }

        Arrays.sort(balls, (o1, o2) -> o1.size - o2.size);

        int[] answer = new int[n];
        int[] colorSum = new int[n + 1]; // 색상별 합
        int sum = 0;
        int start = 0; // 투 포인터

        for (int i = 0; i < n; i++) {
            Ball current = balls[i];

            // 현재 공보다 작은 공들의 합만 남김
            while (balls[start].size < current.size) {
                sum += balls[start].size;
                colorSum[balls[start].color] += balls[start].size;
                start++;
            }

            answer[current.idx] = sum - colorSum[current.color];
        }

        StringBuilder sb = new StringBuilder();
        for (int val : answer) sb.append(val).append("\n");
        System.out.print(sb);
    }
}
