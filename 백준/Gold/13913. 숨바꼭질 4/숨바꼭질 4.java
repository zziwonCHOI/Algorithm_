import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//뒤로 갔다가 순간이동 하는게 더 빠를수 있기 때문에 한방향 탐색만 하면 안ㅋ된다.
//모든 경로를 동시에 탐색하면서 가장 먼저 도착한 경로를 찾아야 한다. ->bfs
public class Main {
    static  int n, k;
    static final int MAX=100001;
    static int[] dist=new int[MAX]; //최단 시간 저장
    static int[] from=new int[MAX];//경로 추적용
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken()); //수빈이 위치
        k=Integer.parseInt(st.nextToken()); //동생 위치

        bfs(n);
        System.out.println(dist[k]);
        printPath(k);
    }

    private static void printPath(int end) {
        Stack<Integer> stack=new Stack<>();
        for(int i=end;i!=-1; i=from[i]){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }

    private static void bfs(int start) {
        Arrays.fill(dist,-1);
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        dist[start]=0;
        from[start]=-1; //시작점은 이전경로 없음

        while (!q.isEmpty()){
            int cur=q.poll();
            for(int next:new int[]{cur-1,cur+1,cur*2}){
                if(next<0||next>=MAX) continue;

                if(dist[next]==-1){//방문 안헸으면
                    dist[next]=dist[cur]+1;
                    from[next]=cur;
                    q.add(next);
                }
            }
        }

    }
}