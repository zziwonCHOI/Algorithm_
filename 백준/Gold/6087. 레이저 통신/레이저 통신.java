import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> lasers = new ArrayList<>();

    static class Point {
        int x, y, dir, mirrors;
        Point(int x, int y, int dir, int mirrors) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    lasers.add(new int[]{j, i});
                }
            }
        }

        bfs();
    }

    static void bfs() {
        int[] start = lasers.get(0);
        int[] end = lasers.get(1);

        visited = new int[h][w];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start[0], start[1], -1, 0));
        visited[start[1]][start[0]] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nextMirror = cur.dir == -1 || cur.dir == d ? cur.mirrors : cur.mirrors + 1;

                while (0 <= nx && nx < w && 0 <= ny && ny < h && map[ny][nx] != '*') {
                    if (visited[ny][nx] < nextMirror) break;

                    if (visited[ny][nx] > nextMirror) {
                        visited[ny][nx] = nextMirror;
                        q.add(new Point(nx, ny, d, nextMirror));
                    }

                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        System.out.println(visited[end[1]][end[0]]);
    }
}