import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long b;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        b=Long.parseLong(st.nextToken());

       arr=new int[n][n];
       for(int i=0; i<n; i++){
           st=new StringTokenizer(br.readLine());
           for(int j=0; j<n; j++){
               arr[i][j]=Integer.parseInt(st.nextToken())%1000;
           }
       }

       int[][] result=power(arr,b);
       for(int[] row:result){
           for(int x:row){
               System.out.print(x+" ");
           }
           System.out.println();
       }

    }
    static int[][] power(int[][] a, long B){
        if(B==1) return a;

        //B를 절반으로 줄여서 계산
        int[][] half=power(a,B/2);
        half=multiply(half,half);

        //B가 짝수일 경우는 그냥 half 곱한게 정답.
        //B가 홀수일 경우는 아직 arr 한번 곱셈이 부족하니까 한번 더 곱한다.
        return (B%2==0)?half:multiply(half,arr);
    }

    static int[][] multiply(int[][] A, int[][] B){
        int[][] res=new int[n][n];
        for(int i=0; i<n; i++){ //res의 행
            for(int j=0; j<n; j++){//res의 열
                for(int k=0; k<n; k++){//곱셈/합산
                    //A의 i 행과 B의 j열
                    res[i][j]=(res[i][j]+A[i][k]*B[k][j])%1000;
                }
            }
        }
        return res;
    }
}