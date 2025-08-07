function solution(numbers, target) {
    var answer = 0;

    dfs(0,0);
    function dfs(start, sum){
        if(start===numbers.length){
            if(sum==target) answer++;
            return;
        }
        dfs(start+1,sum+numbers[start]);
        dfs(start+1,sum-numbers[start]);
    }
    return answer;
}