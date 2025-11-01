//합이 S가 되는 집합을 구한 후
//곱이 최대가 되는 집합 => 궁극적인 목표
//곱이 최대가 되려면 비등비등한 얘들끼리 곱해야 크겠지

function solution(n, s) {
    if(s<n) return [-1];
    
    const base=Math.floor(s/n);
    const rest=s%n;
    const answer=Array(n).fill(base);
    for(let i=0;i<rest; i++){
        answer[n-1-i]+=1;
    }
    
    return answer;
}
