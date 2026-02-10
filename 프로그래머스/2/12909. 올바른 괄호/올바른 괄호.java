import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Queue<Character> q=new LinkedList<>();
        char[] c=s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(c[i]=='('){
                q.add(c[i]);
            }else{
                if(q.isEmpty()){
                    answer=false;
                    break;
                }else{
                    q.poll();
                }
            }
        }
        if(!q.isEmpty()){
            answer=false;
        }
        
        return answer;
    }
}