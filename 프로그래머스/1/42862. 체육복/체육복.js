
function solution(n, l, r) {
    let lost=l.filter(i=> !r.includes(i));
    let reserve=r.filter(i=> !l.includes(i));
    let answer=n-lost.length;
    
    
    lost.sort((a,b) =>b-a);
    reserve.sort((a,b)=>b-a);
    
    let checked={};
    
    for(let i=0; i<lost.length; i++){
        for(let j=0; j<reserve.length; j++){
            if(!checked[j]){
                if(lost[i]+1==reserve[j]||lost[i]-1==reserve[j]){
                    checked[j]=true;
                    answer++;
                    break;
                }
            }
        }
    }
    return answer;
}
