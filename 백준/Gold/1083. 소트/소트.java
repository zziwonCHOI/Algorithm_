import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int s=Integer.parseInt(br.readLine());
        
        for(int i=0; i<n-1&&s>0;i++){
            //i부터 s칸 이내에서 최댓값 찾기
            int maxIdx=i;
            for(int j=i+1; j<n&&j-i<=s; j++){
                if(arr[j]>arr[maxIdx]){
                    maxIdx=j;
                }
            }
            //최댓값이 현재 위치부다 뒤에 있으면 앞으로 땡김
            for(int j=maxIdx; j>i; j--){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                s--;
            }
        }
        
        
        StringBuilder sb=new StringBuilder();
        for(int num=0; num<n; num++){
            sb.append(arr[num]).append(" ");
        }
        System.out.println(sb);
    }
}