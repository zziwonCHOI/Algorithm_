class Solution {

    public int solution(int n, int w, int num) {
        int answer = 0;
        int row=(num-1)/w;
        int pos=(num-1)%w;
        int col=(row%2==0)?pos:(w-pos-1);
        
        for(int i=row+1;i<=(n-1)/w; i++  ){
            //해당 행에 숫자들의 시작과 끝
            int start=i*w+1;
            int end=Math.min(n, start+w-1); //최대 번호인 n을 넘지 않기 위해 
            int actualCol=(i%2==0)?col:(w-col-1);
            int idx=i*w+actualCol+1;
            
            //실제로 상자가 존재하는지 확인하고 더해주기 
            if(idx>=start && idx<=end){
                answer++;
            }
            
        }
        return answer+1;
    }
}