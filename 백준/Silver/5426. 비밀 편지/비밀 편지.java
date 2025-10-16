import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for(int t=0; t<n; t++){
            String s=br.readLine();
            int len=s.length();
            int size=(int)Math.sqrt(len);
            char[][] arr=new char[size][size];

            for(int i=0; i<size; i++){
                String part=s.substring(i * size, (i + 1) * size);
                for(int j=0; j<size; j++){
                    arr[i][j]=part.charAt(j);
                }
            }

            StringBuilder sb=new StringBuilder();
            char[][] newArr=new char[size][size];
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    newArr[i][j]=arr[j][size-i-1];
                }
            }

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    sb.append(newArr[i][j]);
                }
            }

            System.out.println(sb);
        }
    }
}
