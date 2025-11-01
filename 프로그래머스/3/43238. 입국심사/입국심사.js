function solution(n, times) {
    var answer = 0;
    
    let right=Math.max(...times)*n;
    let left=1;
    
    while(left<=right){
        const mid=Math.floor((left+right)/2);
        
        let done=0;
        for(const t of times){
            done += Math.floor(mid/t);
            if(done>=n) break;
        }
        
        if(done>=n){
            answer=mid;
            right=mid-1;
        }else{
            left=mid+1;
        }
        
    }
    return answer;
}