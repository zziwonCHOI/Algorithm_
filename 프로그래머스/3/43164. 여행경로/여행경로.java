import java.util.*;

class Solution {
    
    Map<String, List<String>> routes=new HashMap<>();
    List<String> path=new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        int n=tickets.length;
                
        for(int i=0; i<n; i++){
            String f=tickets[i][0];
            String t=tickets[i][1];
            if(routes.get(f)!=null){
                routes.get(f).add(t);
            }else{
                List<String> list=new ArrayList<>();
                list.add(t);
                routes.put(f,list);
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
    
    // 갈수 있는데까지 계속 가다가 막히면 그때 경로에 넣는다.
    // 경로를 미리 저장하는게 아니라 막힌 순간부터 거꾸로 쌓는다. 
    public void dfs(String cur){
        List<String> list=routes.get(cur);
        
        while(list!=null && !list.isEmpty()){
            String next=list.remove(0);
            dfs(next);
        }        
        path.add(cur);
    }
}