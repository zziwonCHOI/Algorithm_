let fs=require('fs');
let input=fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let n=Number(input[0]);
input.shift();
let result=[];

for(let i=0; i<n;i++){
    let [f,c,a]=input
    a=JSON.parse(a);
    f=f.split('');
    let err=false;
    let isReverse=false; 
    for(let j=0; j<f.length;j++){
        if(f[j]==='R'){
            isReverse=!isReverse;
        }else{      
            if(a.length===0){
                result.push('error');
                err=true;
                break;
            }else{
                if(isReverse){
                    a.pop();
                }else{
                    a.shift();
                }
            }
        }
    }
    if(!err){
        let v=isReverse?a.reverse():a;
        result.push(JSON.stringify(v));
    }
    
    input.splice(0,3);
}

console.log(result.join('\n'));