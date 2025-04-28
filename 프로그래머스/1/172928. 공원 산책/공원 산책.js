function solution(park, routes) {
    var answer = [];
    const n=park.length;
    const m=park[0].length;
    const arr=[...Array(n)].map(()=>Array(m).fill(0))
    var startX=0;
    var startY=0;
    for(let i=0; i<n; i++){
        const line=park[i].split("")
        for(let j=0; j<n; j++){
            arr[i][j]=line[j];
            if(arr[i][j]==='S'){
                startX=i;
                startY=j;
            }
        }
    }
    const dx=[0,0,1,-1];
    const dy=[1,-1,0,0];
    for(let i=0; i<routes.length; i++){
        const command=routes[i].split(" ")
        const d=command[0];
        const step=Number(command[1]);
        const dir=directionCheck(d);
        let flag=true;
        let tempX=startX;
        let tempY=startY;
        for(let k=0; k<step; k++){
            tempX+=dx[dir];
            tempY+=dy[dir];
            
            if(tempX<0||tempY<0||tempX>=n||tempY>=m) {
                flag=false;
                break;
            }
            if(arr[tempX][tempY]=='X') {
                flag=false;
                break;
            }
        }
        if(flag){
            startX=tempX;
            startY=tempY;
        }
        
    }
    
    answer[0]=startX;
    answer[1]=startY;
    return answer;
}

function directionCheck(dir){
    if(dir=='E'){
        return 0;
    }else if(dir=='W'){
        return 1;
    }else if(dir=='S'){
        return 2;
    }else if(dir=='N'){
        return 3;
    }
}