import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer=new ArrayList<>();
        
        Map<String,Integer> termMap=new HashMap<>();
        for(String t:terms){
            String[] curTerm=t.split(" ");
            termMap.put(curTerm[0],Integer.parseInt(curTerm[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] split_p=privacies[i].split(" ");
            String date=split_p[0];
            String target=split_p[1];
            int term=termMap.get(target);
            if(!checkValid(today,date,term)){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static boolean checkValid(String today, String date, int term){
        String[] today_=today.split("\\.");
        int year_today=Integer.parseInt(today_[0]);
        int month_today=Integer.parseInt(today_[1]);
        int day_today=Integer.parseInt(today_[2]);
        
        String[] date_=date.split("\\.");
        int year_date=Integer.parseInt(date_[0]);
        int month_date=Integer.parseInt(date_[1]);
        int day_date=Integer.parseInt(date_[2]);
        
        int calToday=year_today*12*28+month_today*28+day_today;
        int calDate=year_date*12*28+month_date*28+day_date;
        
        if(calToday-calDate>=term*28){
            return false;
        }
        return true;
    }
}