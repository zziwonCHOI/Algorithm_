import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n; // 고객의 수
    static int[][] company;
    static int[][] home;
    static int[][] customer;
    static int[] arr;
    static boolean[] visited;
    static int minDist;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            company = new int[1][2];
            home = new int[1][2];
            customer = new int[n][2];

            st = new StringTokenizer(br.readLine());
            company[0][0] = Integer.parseInt(st.nextToken());
            company[0][1] = Integer.parseInt(st.nextToken());
            home[0][0] = Integer.parseInt(st.nextToken());
            home[0][1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());

            }
            arr = new int[n];
            minDist=Integer.MAX_VALUE;
            visited = new boolean[n];
            perm(0);

            System.out.println("#"+t+" "+minDist);
        }
    }

    // 순열로 고객 집 순서 뽑기
    public static void perm(int cnt) {
        if (cnt == n) {
            distanceCal();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                perm(cnt + 1);
                visited[i]=false;
            }

        }
    }

    public static void distanceCal() {
        int dist=Math.abs(company[0][0]-customer[arr[0]][0])+Math.abs(company[0][1]-customer[arr[0]][1]);
        for(int i=0; i<n-1; i++){
            int x1=customer[arr[i]][0];
            int y1=customer[arr[i]][1];
            int x2=customer[arr[i+1]][0];
            int y2=customer[arr[i+1]][1];
            dist+=Math.abs((x1-x2))+Math.abs(y1-y2);
        }

        dist+=Math.abs(home[0][0]-customer[arr[n-1]][0])+Math.abs(home[0][1]-customer[arr[n-1]][1]);

        minDist=Math.min(minDist,dist);
    }
}