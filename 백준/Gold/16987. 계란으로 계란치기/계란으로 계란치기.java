import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] weights;
    static int[] strongs;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        weights=new int[n];
        strongs=new int[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            strongs[i]=Integer.parseInt(st.nextToken());
            weights[i]=Integer.parseInt(st.nextToken());
        }

        cnt=0;
        broke(0);
        System.out.println(cnt);
    }

    private static void broke(int idx) {
        if(idx==n){
            //깨진 계란 판별
            int broken=0;
            for(int i=0; i<n; i++){
                if(strongs[i]<=0) broken++;
            }
            cnt=Math.max(cnt,broken);
            return;
        }

        //손에 든 계란이 이미 깨진 계란이면 그냥 넘어감
        if(strongs[idx]<=0){
            broke(idx+1);
            return;
        }
        boolean hit=false;
        for(int i=0; i<n; i++){
            //자기 자신의 계란 이거나 이미 깨진 계란은 잡을 수 없다.
            if(idx==i||strongs[i]<=0) continue;

            //계란 idx와 i를 부딪힘
            strongs[i]-=weights[idx];
            strongs[idx]-=weights[i];
            hit=true;

            broke(idx+1); //다음 계란 진행

            //다른 경우에서 최적의 값을 찾을 수 있기 때문에 원복 필수
            strongs[i]+=weights[idx];
            strongs[idx]+=weights[i];

        }

        //때릴 수 있는 게 없었으면 그냥 바로 다음 계란으로
        if(!hit) broke(idx+1);
    }
}
