import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q=new LinkedList<>();
        char[] arr=s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            q.add(arr[i]);
        }
        
        for(int i=0; i<s.length(); i++){
            Queue<Character> copy=new LinkedList<>(q);
            if(checkValidStack(copy,s.length())){
                answer++;
            }
            char cur=q.poll();
            q.add(cur);
        }
        return answer;
    }
    
    public static boolean checkValidStack(Queue<Character> q, int len){
        Stack<Character> stack=new Stack<>();
        boolean answer=true;
        for(int i=0; i<len; i++){
            char cur=q.poll();
            if(stack.isEmpty()){
                if(cur==')'||cur=='}'||cur==']'){
                    return false;
                }
                stack.push(cur);
                continue;
            }
                char top=stack.peek();
                if(cur=='('||cur=='['||cur=='{'){
                    stack.push(cur);
                    continue;
                } 
                if((cur==')'&&top=='(')||(cur==']'&&top=='[')||(cur=='}'&&top=='{')){
                    stack.pop();
                }else{
                    return false;
                }
                
            } 
        
        if(!stack.isEmpty()) answer=false;
        return answer;
    }
}