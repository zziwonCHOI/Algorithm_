import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        cnt=0;

        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int row){
        if(row==n){
            cnt++;
            return;
        }

        for(int col=0; col<n; col++){
            if(isSafe(row,col)){
                arr[row]=col;
                dfs(row+1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {

        for(int i=0 ;i<row; i++){
            //같은 열 또는 같은 대각선인 경우
            if(arr[i]==col||Math.abs(arr[i]-col)==Math.abs(row-i)){
                return false;
            }
        }
        return true;
    }
}
