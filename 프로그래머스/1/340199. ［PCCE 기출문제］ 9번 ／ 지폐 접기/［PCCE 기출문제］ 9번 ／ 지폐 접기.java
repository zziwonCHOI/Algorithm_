import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        
        int w=bill[0];
        int h=bill[1];
        int wW=wallet[0];
        int wH=wallet[1];
    
        while(true){
            int bw=Math.min(w,h);
            int bh=Math.max(w,h);
            
            if(bw<=wW&&bh<=wH) break;
            
            if(bh==h){
                h/=2;
            }else{
                w/=2;
            }
            
            answer++;
        }
               
        return answer;
    }
}