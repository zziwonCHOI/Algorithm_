import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String curBinary=Integer.toBinaryString(n);
        int oneCnt=checkOneCnt(curBinary);
        int idx=1;
        while(true){
            String nextNum=Integer.toBinaryString(n+idx);
            int nxtOneCnt=checkOneCnt(nextNum);
            if(nxtOneCnt==oneCnt){
                answer=n+idx;
                break;
            }
            idx+=1;
            
        }
        return answer;
    }
    
    public static int checkOneCnt(String num){
        int cnt=0;
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i)=='1') cnt++;
        }
        return cnt;
    }
}