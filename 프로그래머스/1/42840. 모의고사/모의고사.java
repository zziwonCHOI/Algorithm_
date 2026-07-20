import java.util.*;

class Solution {
    static List<Integer> totalCnt;
    public int[] solution(int[] answers) {
        int[] a={1,2,3,4,5};
        int[] b={2,1,2,3,2,4,2,5};
        int[] c={3,3,1,1,2,2,4,4,5,5};
        
        int n=answers.length;
        totalCnt=new LinkedList<>();
        
        testExam(a,n,answers);
        testExam(b,n,answers);
        testExam(c,n,answers);
        
        List<Integer> answer=new LinkedList<>();
        int max=0;
        for(int i=1; i<=3; i++){
            if(max<totalCnt.get(i-1)){
                max=totalCnt.get(i-1);
                answer.clear();
                answer.add(i);
            }else if(max==totalCnt.get(i-1)){
                answer.add(i);
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    public static void testExam(int[] way, int n, int[] answers){
        int[] answer=new int[n];
        int cnt=0;
        for(int i=1;i<=n; i++){
            answer[i-1]=way[(i-1)%way.length];
        }
        
        for(int i=0; i<n; i++){
            if(answers[i]==answer[i]) cnt++;
        }
        
        totalCnt.add(cnt);
    }
}