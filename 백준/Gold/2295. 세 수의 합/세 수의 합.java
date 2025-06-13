import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            int num=Integer.parseInt(br.readLine());
            arr[i]=num;
        }

        Arrays.sort(arr);
        
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                list.add(arr[i]+arr[j]);
            }
        }
        Collections.sort(list);
        
        //arr[k]=arr[i]+arr[j]+arr[l] 조건을 만족하는 최대 k 찾기 
        for(int k=n-1; k>=0; k--){
            for(int l=0; l<n; l++){
                int target=arr[k]-arr[l];
                if(Collections.binarySearch(list,target)>=0){
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
        
    }
}