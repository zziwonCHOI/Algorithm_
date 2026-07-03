import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()) stack.add(arr[i]);
            if(stack.peek()!=arr[i]){
                stack.add(arr[i]);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}