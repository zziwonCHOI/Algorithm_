
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static StringBuilder sb;
    static int[] nums;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        sb=new StringBuilder();
        nums=new int[m];
        isSelected=new boolean[n+1];
        perm(0);
        System.out.println(sb);
    }
    public static void perm(int cnt){
        if(cnt==m){
            for(int i=0; i<m; i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(isSelected[i]){
               continue;
            }
            isSelected[i]=true;
            nums[cnt]=i+1;
            perm(cnt+1);
            isSelected[i]=false;
        }

    }
}
