function solution(array, commands) {
    var answer = [];
    
    for(let [i,j,k] of commands){
        const splitArr=array.slice(i-1,j);
        splitArr.sort((a,b)=>a-b);
        answer.push(splitArr[k-1]);
    }
    return answer;
}