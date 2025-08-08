function solution(citations) {
    var answer = 0;
    let n=citations.length;
    citations.sort((a,b)=>b-a);//내림차순 정렬
    
    //인용 횟수가 h번 이상인 논문이 h편 이상 존재하는 최대 h
    //현재 인용 횟수 <= 현재 인용 횟수와 같은 논문의 수
    
    for(let i=0; i<n; i++){
        //현재까지 살펴본 논문 모두의 인용 횟수가  i+1편 이상인 경우 
        if(citations[i]>=i+1){
            answer=i+1;
        }else{
            break;
        }
    }
    return answer;
}