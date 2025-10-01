import java.util.*;

class Solution {
    static int maxDiff=0;
    static int[] answer={-1};
    static int[] apeach;
    static int N;
    static int[] ryan;
    public int[] solution(int n, int[] info) {
        ryan=new int[11];
        N=n;
        apeach=info;
        
        dfs(0,0);
        return answer;
    }
    
    public static void dfs(int idx, int used){
        
        if(idx==11){
            if(used<N){
                ryan[10]+=(N-used); //남은 화살 전부 0으로 설정하기
            }
            int diff=getDiff();
            if(diff>0){
                if(diff>maxDiff){
                    maxDiff=diff;
                    answer=ryan.clone();
                }else if(diff==maxDiff){ //점수 차이가 같은 경우 
                    //낮은 점수를 더 많이 맞춘 경우 비교
                    for(int i=10; i>=0; i--){
                        if(ryan[i]<answer[i]){
                            break;
                        }else if(ryan[i]>answer[i]){
                            answer=ryan.clone();
                            break;
                        }
                    }
                }
            }
            if (used < N) {
                ryan[10] -= (N - used); // 원상 복구(편의상 남은 화살 0점으로 몰아넣기)
            }
            return;
        }
        
        
        //현재 점수에 화살을 쏘는 경우
        if(used+apeach[idx]+1<=N){
            ryan[idx]=apeach[idx]+1;
            dfs(idx+1, used+ryan[idx]);
            ryan[idx]=0; //백트래킹 
        }
        //현재 점수에 화살을 안쏘는 경우
        dfs(idx+1, used);
    }
    
    public static int getDiff(){
        int ryanScore=0; 
        int apeachScore=0;
        
        for(int i=0; i<=10; i++){
            if(apeach[i]==0&&ryan[i]==0) continue;
            
            if(apeach[i]<ryan[i]){
                ryanScore+=(10-i);
            }else if(apeach[i]>=ryan[i]){
                apeachScore+=(10-i);
            }
        }
        
        return ryanScore-apeachScore;
    }
}