function solution(genres, plays) {
    var answer = [];
    const map=new Map();
    const cntMap=new Map();
    
    for(let i=0; i<plays.length; i++){
        const genre=genres[i];
        const play=plays[i];
        
        if(!map.has(genre)) map.set(genre,[]);
        map.get(genre).push({id:i,play});
        
        cntMap.set(genre,(cntMap.get(genre)||0)+play);
    }
    
    //장르 재생별 내림차순 정렬
    const sortedGenres=[...cntMap.entries()].sort((a,b)=>b[1]-a[1]).map(entry=>entry[0]);
    
    for(const genre of sortedGenres){
        const songs=map.get(genre);
        
        //같은 장르 안에서 재생수에 따라 내림차순 정렬
        songs.sort((a,b)=>{
            if(b.play===a.play) return a.id-b.id;
            return b.play-a.play;
        })
        
        answer.push(songs[0].id);
        if(songs.length>1) answer.push(songs[1].id);
    }
    return answer;
}