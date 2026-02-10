import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int cnt=countPrimary(i);
            if(cnt%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }
    
    public static int countPrimary(int num){
        int cnt=0;
        for(int i=1;i*i<=num; i++){
            if(num%i==0){
                if (i * i == num) {
                    cnt += 1;   // 제곱수일 때
                } else {
                    cnt += 2;   // i와 n/i
                }
            }
        }
        return cnt;
    }
}