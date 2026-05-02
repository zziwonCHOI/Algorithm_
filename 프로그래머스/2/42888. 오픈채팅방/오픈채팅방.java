import java.util.*;


class Solution {
    static Queue<String[]> q;
    static Map<String, String> user;
    public String[] solution(String[] record) {
        q=new LinkedList<>();
        user=new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] commend=record[i].split(" ");
            if(commend[0].equals("Enter")){
                enter(commend);
            }else if(commend[0].equals("Leave")){
                leave(commend);
            }else{
                change(commend);
            }
        }
        String[] answer=new String[q.size()];
        int size=q.size();
        for(int i=0; i<size; i++){
            String[] cur=q.poll();
            String name=user.get(cur[1]);
            if(cur[0].equals("Enter")){
                answer[i]=name+"님이 들어왔습니다.";
            }else if(cur[0].equals("Leave")){
                answer[i]=name+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
    
    public static void enter(String[] c){
        q.add(new String[]{c[0],c[1]});
        user.put(c[1],c[2]);
    }
    
    public static void leave(String[] c){
        q.add(new String[]{c[0],c[1]});
    }
    
    public static void change(String[] c){
        user.put(c[1],c[2]);
    }
}