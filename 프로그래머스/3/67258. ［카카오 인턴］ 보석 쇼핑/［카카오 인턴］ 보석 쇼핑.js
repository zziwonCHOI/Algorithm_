function solution(gems) {
    var answer = [0,gems.length-1]; //최소 구간(시작, 끝) 초기화
    const kindCount=new Set(gems).size;
    const gemMap=new Map(); //현재 구간 내 보석 개수 카운트 
    let left=0;
    
    for(let right=0; right<gems.length; right++){
        //오른쪽 포인터 확장
        gemMap.set(gems[right],(gemMap.get(gems[right])||0)+1);
        
        //모든 종류가 포함된 경우 왼쪽 포인터 이동
        while(gemMap.size===kindCount){
            //현재 구간이 더 짧으면 업데이트
            if(right-left<answer[1]-answer[0]){
                answer=[left,right];
            }
            
            //왼쪽 보석 줄이기
            gemMap.set(gems[left],gemMap.get(gems[left])-1);
            if(gemMap.get(gems[left])===0){
                gemMap.delete(gems[left]);
            }
            left++;
        }
    }
    
    return [answer[0]+1,answer[1]+1];
}