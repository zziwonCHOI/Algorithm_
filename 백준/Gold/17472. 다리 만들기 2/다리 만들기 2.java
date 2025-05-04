import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int isLand = 0;
    static PriorityQueue<Edge> pq;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int s, e, cost;
        Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost; // 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 라벨링
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    isLand++;
                    bfs(i, j);
                }
            }
        }

        // 2. 다리 후보 만들기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    makeBridge(i, j, arr[i][j]);
                }
            }
        }

        // 3. 크루스칼 알고리즘
        parent = new int[isLand + 1];
        for (int i = 0; i <= isLand; i++) {
            parent[i] = i;
        }

        int result = 0;
        int bridge_cnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int a = find(edge.s);
            int b = find(edge.e);
            if (a != b) {
                union(a, b);
                result += edge.cost;
                bridge_cnt++;
            }
        }

        // 4. 연결 확인
        if (bridge_cnt != isLand - 1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    // 섬 라벨링 BFS
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        arr[x][y] = isLand;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = isLand;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 다리 후보 만들기
    public static void makeBridge(int x, int y, int num) {
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;
            int len = 0;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;

                if (arr[nx][ny] == num) break; // 같은 섬이면 끝
                if (arr[nx][ny] == 0) {
                    len++;
                } else { // 다른 섬
                    if (len >= 2) {
                        pq.add(new Edge(num, arr[nx][ny], len));
                    }
                    break;
                }
            }
        }
    }

    // union-find
    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}