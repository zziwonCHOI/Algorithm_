function solution(new_id) {
    var str = new_id;
    
    str=str.toLowerCase();
    
    str=str.replace(/[^a-z0-9-_.]/g,'');
    str=str.replace(/\.{2,}/g,'.');
    str=str.replace(/^\.|\.$/g,'');
    if(str==="") str='a';
    str=str.slice(0,15);
    str=str.replace(/\.$/g,'');
    while (str.length < 3) {
        str += str[str.length - 1];
    }
    return str;
}