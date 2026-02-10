import java.util.*;

class Solution {
    public int solution(int n) {
        
        String threeS="";
        
        while(n>0){
            threeS+=(n%3);
            n/=3;
        }
        
        return Integer.parseInt(threeS,3);
    }
}