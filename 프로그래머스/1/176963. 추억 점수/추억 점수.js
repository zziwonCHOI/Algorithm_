function solution(name, yearning, photo) {
    var answer = [];
    const map= new Map();
    
    for(let i=0; i<name.length; i++){
        map.set(name[i],yearning[i]);
    }
    
    for(let i=0; i<photo.length; i++){
        let total=0;
        var arr=photo[i];
        console.log(arr)
        for(let j=0; j<arr.length; j++){
            if(map.has(arr[j])){
                total+=map.get(arr[j]);
            }
        }
        answer[i]=total
    }
    return answer;
}