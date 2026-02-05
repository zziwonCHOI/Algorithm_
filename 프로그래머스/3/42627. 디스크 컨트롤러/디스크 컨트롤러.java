import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        //일단 요청 시간 대로 입력을 정렬 하기
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        PriorityQueue<Job> pq= new PriorityQueue<>(
            (a,b)->{
                if(a.time!=b.time) return a.time-b.time;
                if(a.start!=b.start) return a.start-b.start;
                return a.id-b.id;
            }
        );
        
        int time=0;
        int idx=0;
        int total=0;
        int finished=0;
        
        int n=jobs.length;
        
        while(n>finished){
            while(idx<n && jobs[idx][0]<=time){
                pq.add(new Job(idx, jobs[idx][0],jobs[idx][1])) ;
                idx++;
            }
            
            if(!pq.isEmpty()){
                Job cur=pq.poll();
                time +=cur.time;
                total+=time-cur.start;
                finished++;
            }else{
                time=jobs[idx][0];
            }
        }
        
        return total/n;
    }
    
    static class Job{
        int id;
        int start;
        int time;
        
        Job(int id, int start, int time){
            this.id=id;
            this.start=start;
            this.time=time;
        }
    }
}