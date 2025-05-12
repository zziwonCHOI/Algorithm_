import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int totalCnt;
    static LinkedList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        totalCnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list=new LinkedList<int[]>();
                if (!visited[i][j]) {
                    list=bfs(i, j,map[i][j]);
                    sideCheck(list);
                }
            }
        }
        System.out.println(totalCnt);

    }

    public static LinkedList<int[]> bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<int[]>();
        LinkedList<int[]> area=new LinkedList<>();
        area.add(new int[]{x,y});
        q.add(new int[] { x, y});
        visited[x][y]=true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int k = 0; k < 8; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (!visited[nx][ny]) {
                    if(h==map[nx][ny]) {
                        q.add(new int[] {nx,ny});
                        visited[nx][ny]=true;
                        area.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return area;

    }

    public static void sideCheck(LinkedList<int[]> l) {
        for(int[] cur:l) {
            boolean flag=true;
            for(int k=0; k<8; k++) {
                int nx=cur[0]+dx[k];
                int ny=cur[1]+dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                //덩어리 주변에 더 큰게 있는 경우
                if(map[nx][ny]>map[cur[0]][cur[1]]) {
                    flag=false;
                    break;
                }
            }
            if(!flag) {
                return;
            }
        }
        totalCnt++;

    }
}