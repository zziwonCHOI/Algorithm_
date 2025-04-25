function solution(s) {
    var answer = true;
    
    const arr=s.split('').filter(v=> /^\d$/.test(v))
    
    if(s.length!=4 && s.length!=6||arr.length!=s.length){
        answer=false;
    }
    return answer;
}