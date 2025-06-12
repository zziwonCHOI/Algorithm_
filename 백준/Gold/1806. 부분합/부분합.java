import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int target=Integer.parseInt(st.nextToken());

        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int minLen=Integer.MAX_VALUE;
        int left=0;
        int sum=0;
        for(int right=0; right<n; right++){
            sum+=arr[right];
            //조건 만족할때까지 완쪽 포인터 이동시키며 길이 줄
            while(sum>=target){
                minLen=Math.min(minLen,right-left+1);
                sum-=arr[left++];
            }
        }


        System.out.println(minLen==Integer.MAX_VALUE?0:minLen);

    }
}