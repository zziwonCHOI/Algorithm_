import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] digit = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };
        
        for(int i=0; i<digit.length; i++){
            s=s.replace(digit[i],String.valueOf(i));
        }
    
        return Integer.parseInt(s);
    }
}