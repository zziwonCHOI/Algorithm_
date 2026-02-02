import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> inTime=new HashMap<>();
        Map<Integer, Integer> totalTime=new TreeMap<>();
        int basicMin=fees[0];
        int basicFee=fees[1];
        int additionMin=fees[2];
        int additionFee=fees[3];
        
        for(int i=0; i<records.length; i++){
            String[] s=records[i].split(" ");
            int car=Integer.parseInt(s[1]);
            
            String[] t=s[0].split(":");
            int time=Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
            
            //IN인 경우는 입차시간 map에 저장하기 
            if(s[2].equals("IN")){
                inTime.put(car,time);
            }else{
                int start=inTime.get(car);
                int duration=time-start;
                
                totalTime.put(car,totalTime.getOrDefault(car,0)+duration);
                inTime.remove(car);
            }
        }
        //출차 기록이 없는 차량 관리
        int endTime=23*60+59;
        for(int car:inTime.keySet()){
            int start=inTime.get(car);
            int duration=endTime-start;
            
            totalTime.put(car,totalTime.getOrDefault(car,0)+duration);
        }
        int[] answer=new int[totalTime.size()];
        int i=0;
        for(int time:totalTime.values()){
            int fee=basicFee;
            if(time>basicMin){
                int extra=time-basicMin;
                fee+=(int) Math.ceil((double)extra/additionMin)*additionFee;
            }
            answer[i++]=fee;
        }
      
        return answer;
    }
}