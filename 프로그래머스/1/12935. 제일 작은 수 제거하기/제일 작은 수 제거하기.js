function solution(arr) {
    var answer = [];
    
    let min=Math.min(...arr);
    const deleteArr=arr.filter(v=> v!=min);
    if(deleteArr.length==0){
        answer[0]=-1;
    }else{
        answer=deleteArr;
    }
    return answer;
}