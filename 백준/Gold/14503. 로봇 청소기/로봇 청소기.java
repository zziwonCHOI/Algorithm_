import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int cleanCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        cleanCnt = 1;
        map[startX][startY] = 2;

        cleaning(startX, startY, d);

        System.out.println(cleanCnt);
    }

    public static void cleaning(int x, int y, int d) {
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (map[nx][ny] == 0) {
                map[nx][ny] = 2; // 청소 표시
                cleanCnt++;
                cleaning(nx, ny, d);
                return; // 이동했으면 return
            }
        }

        // 주변 4칸 다 청소됐거나 벽인 경우
        int backDir = (d + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];

        if (bx < 0 || by < 0 || bx >= n || by >= m || map[bx][by] == 1) {
            return; // 뒤가 벽이면 stop
        } else {
            cleaning(bx, by, d); // 뒤로 이동
        }
    }
}