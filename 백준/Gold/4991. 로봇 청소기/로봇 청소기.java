import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static List<Point> points;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new char[h][w];
            points = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'o') points.add(0, new Point(i, j));
                    else if (map[i][j] == '*') points.add(new Point(i, j));
                }
            }

            int n = points.size();
            dist = new int[n][n];
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int[][] d = bfs(points.get(i));
                for (int j = 0; j < n; j++) {
                    dist[i][j] = d[points.get(j).x][points.get(j).y];
                    if (dist[i][j] == -1) possible = false;
                }
            }

            if (!possible) {
                System.out.println(-1);
                continue;
            }

            int[] order = new int[n - 1];
            for (int i = 1; i < n; i++) order[i - 1] = i;
            int min = Integer.MAX_VALUE;

            do {
                int sum = dist[0][order[0]];
                for (int i = 0; i < order.length - 1; i++) {
                    sum += dist[order[i]][order[i + 1]];
                }
                min = Math.min(min, sum);
            } while (nextPerm(order));

            System.out.println(min);
        }
    }

    static int[][] bfs(Point start) {
        int[][] d = new int[h][w];
        for (int[] row : d) Arrays.fill(row, -1);
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        d[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (map[nx][ny] == 'x' || d[nx][ny] != -1) continue;
                d[nx][ny] = d[p.x][p.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        return d;
    }

    static boolean nextPerm(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i <= 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) j--;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        for (int a = i, b = arr.length - 1; a < b; a++, b--) {
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        return true;
    }
}