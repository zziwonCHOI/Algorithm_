import java.io.*;
import java.util.*;

public class Main {
    public static class Pos implements Comparable<Pos> {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pos o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                return this.y > o.y ? 1 : -1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 카페 개수

            ArrayList<Pos> cafe = new ArrayList<>();
            cafe.add(new Pos(-1, 0)); // 더미 노드 (1-based index 맞추기용)

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cafe.add(new Pos(x, y));
            }

            Collections.sort(cafe); // x 기준 정렬, 같으면 y 기준

            int idx = 1;
            while (idx <= N) {
                // x축이 같은 경우
                if (cafe.get(idx).x == cafe.get(idx - 1).x) {
                    idx++;
                }
                // y축이 같은 경우
                else if (cafe.get(idx).y == cafe.get(idx - 1).y) {
                    idx++;
                }
                // x, y 다를 경우
                else {
                    int cur = idx;
                    int curX = cafe.get(idx).x;

                    // x축이 같아질 때까지
                    while (idx <= N && cafe.get(idx).x == curX) {
                        idx++;
                    }

                    // subList를 복사해서 reverse하고 다시 원본 리스트에 반영
                    List<Pos> reversed = new ArrayList<>(cafe.subList(cur, idx));
                    Collections.reverse(reversed);
                    for (int r = 0; r < reversed.size(); r++) {
                        cafe.set(cur + r, reversed.get(r));
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            for (int d = 0; d < M; d++) {
                int tmp = Integer.parseInt(st.nextToken());
                System.out.println(cafe.get(tmp).x + " " + cafe.get(tmp).y);
            }
        }
    }
}