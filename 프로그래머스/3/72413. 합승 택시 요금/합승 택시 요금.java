import java.util.*; 

class Solution {
    static class Node{
        int to;
        int cost;
        
        Node(int t, int c){
            to=t;
            cost=c;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Node>> graph=new ArrayList<ArrayList<Node>>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] f:fares){
            graph.get(f[0]).add(new Node(f[1],f[2]));
            graph.get(f[1]).add(new Node(f[0],f[2]));
        }
        
        //s->k까지 최단거리
        int[] distS=dijkstra(s,n,graph);
        //k->a까지 최단거리
        int[] distA=dijkstra(a,n,graph);
        //k->b까지 최단거리
        int[] distB=dijkstra(b,n,graph);
        
        //최적의 k를 구하기 위해 모든 노드를 k로 시도
        for(int k=1; k<n+1; k++){
            answer=Math.min(answer,distS[k]+distA[k]+distB[k]);
        }
        return answer;
    }
    
    public static int[] dijkstra(int s, int n, ArrayList<ArrayList<Node>> graph){
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        
        //우선순위큐로 비용이 작은 노드부터 꺼내야한다. 
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.offer(new Node(s,0));
        
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            
            if(cur.cost>dist[cur.to]) continue; //이미 더 짧은 경로가 있으면 스킵
            
            //이웃된 노드들 모두 확인 
            for(Node next:graph.get(cur.to)){
                if(dist[cur.to]+next.cost<dist[next.to]){
                    dist[next.to]=dist[cur.to]+next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
