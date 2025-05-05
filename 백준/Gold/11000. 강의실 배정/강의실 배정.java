import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int[][] times=new int[n][2];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            times[i][0]=a;
            times[i][1]=b;
        }


        Arrays.sort(times,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(times[0][1]);
        for(int i=1; i<n; i++){
            //가장 빨리 끝나는 강의실이 현재 강의 시작 시간보다 작거나 같으면 재사용 
           if(pq.peek()<=times[i][0]){
               pq.poll();
           }
           pq.add(times[i][1]);
        }

        System.out.println(pq.size());
    }
}