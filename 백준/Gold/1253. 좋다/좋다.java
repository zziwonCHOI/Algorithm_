import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt=0;

        for(int i=0; i<n; i++){
            int cur=arr[i];
            int left=0;
            int right=n-1;
            while(left<right){
                if(left==i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }

                int sum=arr[left]+arr[right];
                if(sum==cur){
                    cnt++;
                    break;
                }else if(sum<cur){
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
