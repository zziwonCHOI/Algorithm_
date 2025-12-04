import java.util.*;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        int n=park.length;
        int m=park[0].length;
        
        Arrays.sort(mats);
       
        for(int k=mats.length-1; k>=0; k--){
            int num=mats[k];
            
            //해당 돗자리가 가능한지 확인하기
            for(int i=0; i+num<=n; i++){
                for(int j=0; j+num<=m; j++){
                    if(isPossible(i,j,num,park )){
                        return num;
                    }
                }
            }
        }
        return -1;
    }
    public static boolean isPossible(int x, int y, int num, String[][] park){
        for(int i=x; i<x+num; i++){
            for(int j=y; j<y+num; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}