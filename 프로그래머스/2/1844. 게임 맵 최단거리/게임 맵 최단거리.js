function solution(maps) {
    var answer = Number.MAX_SAFE_INTEGER;
    let dx=[0,1,0,-1];
    let dy=[1,0,-1,0];
    let row=maps.length;
    let col=maps[0].length;
    
    const visited= Array.from({ length: row }, () => Array(col).fill(false));
    
    function bfs(){
        const queue=[];
        queue.push([0,0,1]);
        visited[0][0]=true;
        
        while(queue.length!==0){
            const [x,y,dis]=queue.shift();
            for(let k=0; k<4; k++){
                let nx=x+dx[k];
                let ny=y+dy[k];
                
                if(nx===row-1&&ny===col-1){
                    answer=Math.min(answer,dis+1);
                    break;
                }
                if(nx<0||ny<0||nx>=row||ny>=col) continue;
                
                if(maps[nx][ny]===0) continue;
                
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    queue.push([nx,ny,dis+1]);
                }
             }
        }
    }
    bfs();
    return answer==Number.MAX_SAFE_INTEGER?-1:answer;
}