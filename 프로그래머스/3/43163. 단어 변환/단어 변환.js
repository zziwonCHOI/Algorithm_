function solution(begin, target, words) {
    var answer = 0;
    if(!words.includes(target)) return 0;
    
    //두 단어의 차이가 1개인지 구하는 함수 
    const isAdj=(a,b)=>{
        let diff=0;
        for(let i=0; i<a.length; i++){
            if(a[i]!==b[i]) diff++;
        }
        return diff===1;
    }
    
    //단어를 체크하기 때문에 visited는 Set 이용하기 
    const visited=new Set();
    const queue=[[begin,0]];

    while(queue.length){
        const [word,depth]=queue.shift();
        if(word===target) return depth;
        
        for(const next of words){ //나머지 단어들을 하나씩 돌아가면서 비교하기 
            if(!visited.has(next)&& isAdj(word,next)){
                visited.add(next);
                queue.push([next,depth+1]);
            }
        }
        
    }
    
}