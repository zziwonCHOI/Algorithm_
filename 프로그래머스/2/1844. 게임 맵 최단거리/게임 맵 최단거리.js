function solution(maps) {
    const n=maps.length;
    const m=maps[0].length;
    
    const dx=[0,1,0,-1];
    const dy=[1,0,-1,0];
    
    const visited=Array.from({length:n},()=> Array(m).fill(false));
    visited[0][0]=true;
    
    // x,y,distance
    const queue=[[0,0,1]];
    
    while(queue.length>0){
        const [x,y,dist]=queue.shift();
        
        if(x===n-1 && y===m-1){
            return dist;
        }
        
        for(let i=0; i<4; i++){
            const nx=x+dx[i];
            const ny=y+dy[i];
            
            if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||maps[nx][ny]==0) continue;
            
            visited[nx][ny]=true;
            queue.push([nx,ny,dist+1]);
        }
    }
    return -1;
}