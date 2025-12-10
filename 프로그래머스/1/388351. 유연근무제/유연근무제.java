class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++){
            int[] times=timelogs[i];
            if(timeCheck(schedules[i],times, startday)){
                answer+=1;
            }
        }
        return answer;
    }
    
    static boolean timeCheck(int t, int[] times, int day){
        int limit=addTenMinutes(t);
        for(int i=0; i<times.length; i++){
            int time = addTenMinutes(times[i]);
            if(day >= 1 && day <= 5){
                if(times[i] > limit){
                    return false;
                }
            }
            if(day==7){
                day=1;
            }else{
                day+=1;
            }
        }
        return true;
    }
    static int addTenMinutes(int t) {
        int hour = t / 100;
        int min = t % 100;

        min += 10;
        if (min >= 60) {
            hour++;
            min -= 60;
        }

        return hour * 100 + min;
    }
}
