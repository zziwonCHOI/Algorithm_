function solution(progresses, speeds) {
    var answer = [0];
    let arr=progresses.map((v,i)=>Math.ceil((100-v)/speeds[i]));
    let maxDay=arr[0];
    
    for(let i=0, j=0; i<arr.length;i++){
        if(maxDay>=arr[i]){
            answer[j]+=1;
        }else{
            maxDay=arr[i];
            answer[++j]=1;
        }
    }
    return answer;
}