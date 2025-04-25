function solution(number, limit, power) {
    var answer = 0;
    
    const hopePower=[]; // 각 기사의 약수의 개수 저장 배열(희망 공격력 무기)
    for(let i=1; i<=number; i++){
        let cnt=0; //약수의 개수 카운트
        for(let j=1; j*j<=i; j++){
            if(i%j==0){
                cnt++;
                if(j!==i/j) cnt++;
            }
        }
        answer+=(cnt>limit)?power:cnt;
    }
    
 
    return answer;
}