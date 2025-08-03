import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;   


public class Main {
    static int n; 
    static int d=0; 
    static int k;
    static int l; 
    static int[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static Map<Integer,String> moveInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());

        map=new int[n][n];
        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            map[a-1][b-1]=1;
        }
        
        moveInfo=new HashMap<>();
        l=Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            String b=st.nextToken();
            moveInfo.put(a,b);
        }
        solve();
    }
    private static void solve() {

        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int px=0;
        int py=0;
        int time=0;

        while(true){
            int nx=dx[d]+px;
            int ny=dy[d]+py;
            time++;

            //벽에 부딪힘
            if(nx<0||ny<0||nx>=n||ny>=n) break;

            //자기 몸에 부딪힘
            if(q.contains(ny*n+nx)) break;

            //안부딪히면 이동 시작
            if(map[nx][ny]==1){//사과가 있는 경우
              map[nx][ny]=0;
              q.add(ny*n+nx);
            }else{//사과가 없는 경우
                q.add(ny*n+nx); //머리 추가
                q.poll();//꼬리 잘라
            }
            
            //방향 전환
            if(moveInfo.containsKey(time)){
                String data=moveInfo.get(time);
                if(data.equals("D")){
                    d+=1;
                    if(d==4) d=0;
                }else{
                    d-=1;
                    if(d==-1) d=3;
                }
            }
            px=nx;
            py=ny;
        }
        System.out.println(time);
    }
}