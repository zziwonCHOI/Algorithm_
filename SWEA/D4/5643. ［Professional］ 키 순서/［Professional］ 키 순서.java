import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int n,m;
    static int[][] stu;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            m=Integer.parseInt(br.readLine());
            stu=new int[n+1][n+1];

            for(int i=0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                stu[a][b]=1;
            }

            for(int k=1; k<=n; k++){
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        if(stu[i][k]==1&&stu[k][j]==1){
                            stu[i][j]=1;
                        }
                    }
                }
            }
            int result=0;
            for(int i=1; i<=n; i++){
                int cnt=0;
                for(int j=1; j<=n; j++){
                    if(i==j) continue;
                    if(stu[i][j]==1||stu[j][i]==1){
                        cnt++;
                    }
                }
                if(cnt==n-1){
                    result++;
                }
            }
            System.out.println("#"+t+" "+result);


        }
    }
}