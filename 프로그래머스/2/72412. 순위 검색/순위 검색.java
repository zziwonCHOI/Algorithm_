import java.util.*;

class Solution {
    static Map<String,ArrayList<Integer>> map=new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer =new int[query.length];
   
        for(String i:info){
            String[] cur=i.split(" ");
            String[] conditions=Arrays.copyOf(cur,4);
            int score=Integer.parseInt(cur[4]);
            
            makeCases(conditions,0,"",score);
        }
        
        for(String k:map.keySet()){
            Collections.sort(map.get(k));
        }
        
        for(int i=0; i<query.length;i++){
            String q=query[i].replaceAll(" and "," ");
            String[] parts=q.split(" ");
            String key=parts[0]+parts[1]+parts[2]+parts[3];
            int target=Integer.parseInt(parts[4]);
            
            if(!map.containsKey(key)){
                answer[i]=0;
                continue;
            }
            
            ArrayList<Integer> list=map.get(key);
            int idx=lowerBound(list,target);
            answer[i]=list.size()-idx;
        }
        return answer;
    }
    
    public static void makeCases(String[] info,int depth, String key, int score){
        if(depth==4){
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(score);
            return;
        }
        
        makeCases(info, depth+1, key+info[depth],score);
        makeCases(info, depth+1, key+"-",score);
        
    }
    
    public static int lowerBound(ArrayList<Integer> list, int target){
        int left=0;
        int right=list.size();
        
        while(left<right){
            int mid=(left+right)/2;
            if(list.get(mid)<target) left=mid+1;
            else right=mid;
        }
        return left;
    }
}