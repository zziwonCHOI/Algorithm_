function solution(tickets) {
    var answer = [];
    
    let map=new Map();
    //그래프 생성 
    for(let [from,to] of tickets){
        if(!map.has(from)) map.set(from, []);
        map.get(from).push(to);
    }
    
    //알파벳 순 정렬
    for(let [from, tos] of map){
        map.set(from,tos.sort())
    }
    
    const path=[];
    function dfs(cur){
        const dest=map.get(cur)||[];
        
        while(dest.length>0){
            const next=dest.shift(); //알파벳 순으로 pop
            dfs(next);
        }
        //역순으로 넣기 
        path.push(cur);
    }
    
    dfs("ICN");
  
    return path.reverse();
}