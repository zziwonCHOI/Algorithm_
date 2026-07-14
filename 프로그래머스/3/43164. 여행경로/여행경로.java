import java.util.*;

class Solution {
    static Map<String, List<String>> routes=new HashMap<>();
    static List<String> path=new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        int n=tickets.length;
        
        for(int i=0; i<n; i++){
            String from=tickets[i][0];
            String to=tickets[i][1];
            if(routes.get(from)!=null){
                routes.get(from).add(to);
            }else{
                List<String> list=new ArrayList<>();
                list.add(to);
                routes.put(from,list);
            }
        }
        
        for(String k:routes.keySet()){
            List<String> list=routes.get(k);
            Collections.sort(list);
        }
      
        dfs("ICN");
        
        Collections.reverse(path);
        return path.toArray(new String[0]);
        
    }
    
    public static void dfs(String cur){
        List<String> list=routes.get(cur);
        
        //끝이 아니고 리스트가 비어있지 않으면 계속 돌아서 끝까지 
        while(list!=null&& !list.isEmpty()){
            //remove는 삭제하면서 그 값을 반환한다
            String next=list.remove(0);
            dfs(next);
        }
        path.add(cur);
    }
}