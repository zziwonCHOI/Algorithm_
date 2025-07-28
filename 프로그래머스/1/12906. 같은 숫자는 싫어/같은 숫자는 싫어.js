function solution(arr)
{
    let stack=[];
    for(let i=0;i<arr.length;i++){
        if(arr[i-1]!==arr[i]){
            stack.push(arr[i]);
        }
    }
    
    return stack;
}