import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack=new Stack<>();
        char[] arr=s.toCharArray();
        
        for(int i=0; i<arr.length; i++){
            char cur=arr[i];
            if(stack.isEmpty()) {
                if(cur==')'){
                    answer=false;
                    break;
                }
                stack.push(arr[i]);
                continue;
            }
            
            if(cur=='('){
                stack.push(cur);
            }else{
               if(stack.peek()=='('){
                    stack.pop();
                }else{
                    answer=false;
                    break;
                }
            }
        }

        if(!stack.isEmpty()){
            answer=false;
        }
        return answer;
    }
}