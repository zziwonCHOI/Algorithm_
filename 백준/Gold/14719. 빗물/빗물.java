import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());

        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());

        int[] arr=new int[w];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
        }


        int[] leftMax=new int[w];
        int[] rightMax=new int[w];

        leftMax[0]=arr[0];
        for(int i=1; i<w; i++){
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        

        rightMax[w-1]=arr[w-1];
        for(int i=w-2; i>=0; i--){
            rightMax[i]=Math.max(rightMax[i+1],arr[i]);
        }
        int result=0;
        for(int i=1; i<w; i++){
            int waterHeight=Math.min(leftMax[i],rightMax[i])-arr[i];
            if(waterHeight>0){
                result+=waterHeight;
            }
        }

        System.out.println(result);
    }
}