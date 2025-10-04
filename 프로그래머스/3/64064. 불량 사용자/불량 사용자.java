import java.util.*;

class Solution {
    static List<List<String>> candidates=new ArrayList<>();
    static Set<Set<String>> results=new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        for(String ban:banned_id){
            List<String> matched=new ArrayList<>();
            for(String user:user_id){
                //현재 ban이랑 현재 user가 매치되면 넣기 
                if(isMatch(ban, user)) matched.add(user);
            }
            candidates.add(matched);
        }
        
        dfs(0,new HashSet<>());
        return results.size();
    }
    
    public static boolean isMatch(String ban, String user){
        //일단 길이 다르면 바로 false
        if(user.length()!=ban.length()) return false;
        
        //user를 하나씩 돌면서 확인 
        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i)=='*') continue;
            if(user.charAt(i)!=ban.charAt(i)) return false;
        }
        return true;
    }
    
    public static void dfs(int idx, Set<String> cur){
        if(idx==candidates.size()){
            results.add(new HashSet<>(cur));
            return;
        }
        
        //후보 리스트들 돌면서 확인 
        for(String user:candidates.get(idx)){
            //현재 set에 포함되어 있지 않는 경우
            if(!cur.contains(user)){
                //넣고
                cur.add(user);
                //돌리고
                dfs(idx+1, cur);
                //되돌리기
                cur.remove(user);
            }
        }
    }

}