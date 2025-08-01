function solution(n, computers) {
    var answer = 0;
    const visited=new Array(n).fill(false);
    let networkCnt=0;
    
    function dfs(node){
        visited[node]=true;
        for(let i=0; i<n; i++){
            if(computers[node][i]===1&&!visited[i]){
                dfs(i);
            }
        }
    }
    
    for(let i=0; i<n; i++){
        if(!visited[i]){
            dfs(i);
            networkCnt++;
        }
    }
    return networkCnt;
}