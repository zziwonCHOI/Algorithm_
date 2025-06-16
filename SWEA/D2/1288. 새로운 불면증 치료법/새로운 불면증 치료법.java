import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int num=Integer.parseInt(br.readLine());
            Set<Character> set=new HashSet<>();
            int n=1;
            int result=0;
            int base=num;
            while(true){
                int cur=base*n;
                char[] arr=String.valueOf(cur).toCharArray();

                for(int i=0; i<arr.length;i++){
                    set.add(arr[i]);
                }

                if(set.size()==10){
                    result=cur;
                    break;
                }

                n++;

            }
            System.out.println("#"+t+" "+result);
        }

    }
}