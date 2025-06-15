import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] weight;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        weight=new int[n];
        values=new int[n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            weight[i]=w;
            values[i]=v;
        }
        int maxV=packing(weight,values,k);
        System.out.println(maxV);
    }

    public static int packing(int[] w, int[] v, int k){
        int[][] dp=new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=k; j++){
                if(w[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]]);
                }
            }
        }
        return dp[n][k];
    }
}