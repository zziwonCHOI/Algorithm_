import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int r;
    static int[][] arr;
    static int result;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            r=n/2;
            result=Integer.MAX_VALUE;
            isSelected=new boolean[n];
            comb(0,0);
            System.out.println("#"+t+" "+result);
        }
    }

    public static void comb(int idx, int cnt){
        //n/2만큼 뽑았을 때
        if(cnt==r){
            result=Math.min(result,cal());
            return;
        }

        for(int k=idx;k<n;k++){
            isSelected[k]=true;
            comb(k+1, cnt+1);
            isSelected[k]=false;
        }
    }

    public static int cal(){
        int x=0;
        int y=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;

                if(isSelected[i]&&isSelected[j]){
                    x+=arr[i][j];
                }else if(!isSelected[i]&&!isSelected[j]){
                    y+=arr[i][j];
                }
            }
        }
        return Math.abs(x-y);
    }
}