function solution(n, edge) {

    const graph=Array.from({length:n+1},()=>[]);
    for(const [a,b] of edge){
        graph[a].push(b);
        graph[b].push(a);
    }
    
    const distance=new Array(n+1).fill(-1);
    distance[1]=0;
    
    
    const queue=[1];
    while(queue.length>0){
        const cur=queue.shift();
        
        for(const next of graph[cur]){
            if(distance[next]==-1){
                distance[next]=distance[cur]+1;
                queue.push(next);
            }
        }
    }
    
    const max=Math.max(...distance);
    return distance.filter(d=>d==max).length;
}

//dfs가 안되는 이유: dfs는 먼저 깊게 들어가서 경로를 탐색하기 때문에 최단거리 보장을 하지 않는다. 
//bfs는 가까운 곳부터 차례로 탐색하기 때문에 간선의 개수가 가장 적은 경로(최단 경로)를 보장한다. 