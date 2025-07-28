function solution(s){
    var answer = true;
    var arr=s.split("");
    
    let stack=[];
    let idx=0;
    for(let i=0; i<arr.length;i++){
        if(arr[i]=="("){
            stack.push(arr[i]);
        }else if(arr[i]==")"){
            if(stack.length==0){
                answer=false;
                break;
            }
            stack.pop();
        }
    }
    if(stack.length!=0){
        answer=false;
    }

    return answer;
}