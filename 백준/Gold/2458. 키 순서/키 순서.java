import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] stu;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        stu=new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            stu[a][b]=1;
        }

        //모든 학생 쌍에 대해 간접적인 키 비교 결과까지 파악해야 하기 때문에 플로이드 워셜을 사용해야한다.
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(stu[i][k]==1&&stu[k][j]==1){
                        stu[i][j]=1;
                    }
                }
            }
        }
        int cnt=0;
        for(int i=1; i<=n; i++){
            int c=0;
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(stu[i][j]==1||stu[j][i]==1){
                    c++;
                }
            }
            if(c==n-1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}