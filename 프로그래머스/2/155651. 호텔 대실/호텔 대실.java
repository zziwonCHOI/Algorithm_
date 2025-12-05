import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int n=book_time.length;
        int[] starts=new int[n];
        int[] ends=new int[n];
        
        for(int i=0; i<n;i++){
            starts[i]=toMin(book_time[i][0]);
            ends[i]=toMin(book_time[i][1])+10;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int i=0;
        int j=0;
        int r=0; //현재 사용중인 방의 개수 
        int totalRoom=0; //총 사용한 방의 개수 
        
        while(i<n){
            if(starts[i]<ends[j]){ //기존 방의 종료 시간보다 새로운 방의 시작 시간이 빠른 경우 
                r++;
                totalRoom=Math.max(totalRoom,r);
                i++;
            }else{
                j++;
                i++;
            }
        }
        return totalRoom;
    }
    
    static int toMin(String time){
        String[] t=time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
}

//어떤 손님이 도착한 시건이 기존에 있던 방의 완료 시간보다 빠른지 느린지 확인