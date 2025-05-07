import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m,d;
    static int[][] map;
    static int ans;
    static int[] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        ans=0;
        picked=new int[3];
        comb(0,0);
        System.out.println(ans);
    }

    //궁수 세 명의 위치 뽑기
    public static void comb(int cnt, int start){
        if(cnt==3){
            ans=Math.max(ans,game());
            return;
        }
        for(int i=start; i<m; i++){
            picked[cnt]=i;
            comb(cnt+1, i+1);
        }
    }

    public static int game(){
        int count=0;
        int[][] status=new int[n][m];
        for(int line=n; line>0; line--){
            for(int pick:picked){
                for(int dis=1; dis<=d; dis++){
                    int cnt=attack(status,dis,line,pick);
                    if(cnt<0) continue;
                    count+=cnt;
                    break;
                }
            }
        }
        return count;
    }

    public static int attack(int[][] status, int dis, int line, int pick){
        int targetX;
        for(int targetY=pick-dis; targetY<=pick+dis; targetY++){
            targetX=line-(dis-Math.abs(targetY-pick));
            if(targetX<0||targetX>=line||targetY<0||targetY>=m) continue;
            if(map[targetX][targetY]==0) continue;
            if(status[targetX][targetY]==0) {
                status[targetX][targetY]=line;
                return 1;

            }else if(status[targetX][targetY]==line) return 0;
        }
        return -1;
    }
}