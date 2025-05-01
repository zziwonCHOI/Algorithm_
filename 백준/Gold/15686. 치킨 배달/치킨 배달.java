import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1. 집과 치킨집의 좌표를 각각 list에 저장해둔다.
//2. 치킨집이 open 한 개수가 M과 같다면 모든 집에 대하여 M개의 치킨집 중 최단거리를 계산한다.
//3. 탐색을 시작하는 지점이 치킨집 list의 사이즈가 벗어나게 되면 탐색을 종료한다.

class Point{
    int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        home=new ArrayList<>();
        chicken=new ArrayList<>();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());

                if(map[i][j]==1){
                    home.add(new Point(i,j));
                }else if(map[i][j]==2){
                    chicken.add(new Point(i,j));
                }
            }
        }

        ans=Integer.MAX_VALUE;
        open=new boolean[chicken.size()];

        dfs(0,0);
        System.out.println(ans);

    }

    public static void dfs(int start, int cnt){
      if(cnt==m){
          int res=0;

          for(int i=0; i<home.size(); i++){
              int temp=Integer.MAX_VALUE;

              //어떤 집과 치킨집 중 open 치킨집으의 모든 거리를 비교한다.
              for(int j=0; j<chicken.size(); j++){
                  if(open[j]){
                      int dis=Math.abs(home.get(i).x-chicken.get(j).x)+Math.abs(home.get(i).y-chicken.get(j).y);
                      temp=Math.min(temp,dis);
                  }
              }
              res+=temp;
          }
          ans=Math.min(ans,res);
          return;

      }

      for(int i=start; i<chicken.size(); i++){
          open[i]=true;
          dfs(i+1,cnt+1);
          open[i]=false;
      }

    }

}
