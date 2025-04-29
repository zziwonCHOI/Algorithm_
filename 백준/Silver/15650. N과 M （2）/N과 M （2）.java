import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static StringBuilder sb=new StringBuilder();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        nums=new int[m];
        comb(0,0);
        System.out.println(sb);
    }

    public static void comb(int idx, int start){
        if(idx==m){
            for(int i=0; i<m; i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++){
            nums[idx]=i+1;
            comb(idx+1,i+1);
        }

    }
}