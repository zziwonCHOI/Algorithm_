import java.util.*;

class Solution {
    static Map<String, Integer> countMap;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
        countMap=new HashMap<>();
        
        for(String order:orders){
            char[] arr=order.toCharArray();
            Arrays.sort(arr);
            //현재 주문 내역으로 만들수 있는 모든 조합 구하기
            for(int size:course){
                //주문 개수보다 큰 조합은 불가
                if(arr.length>=size){
                    generateComb(arr, size, 0, "");
                }
            }
        }
        
        //course 크기별로 최댓값 찾아서 후보 추가
        for(int size:course){
            int max=0;
            for(Map.Entry<String, Integer> e:countMap.entrySet()){
                if(size==e.getKey().length()){
                    max=Math.max(max, e.getValue());
                }
            }
            
            //현재 찾는 길이 중 횟수가 가장 많은 경우가 2보다 큰 경우만 가능
            if(max>=2){
                //max 값을 가지는 key 값 이 여러개일수 있기 때문에 다시 돌면서 max 값과 같은 값을 가지는 키 값 찾기 
                for(Map.Entry<String, Integer> e:countMap.entrySet()){
                    if(e.getKey().length()==size && e.getValue()==max){
                        answer.add(e.getKey());
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);    
    }
    
    public static void generateComb(char[] arr, int size, int start, String cur){
        if(size==cur.length()){
            countMap.put(cur,countMap.getOrDefault(cur,0)+1);
            return;
        }
        
        for(int i=start; i<arr.length; i++){
            generateComb(arr,size,i+1,cur+arr[i]);
        }
    }
}