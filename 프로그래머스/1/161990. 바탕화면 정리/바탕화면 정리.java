class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int n=wallpaper.length;
        int m = wallpaper[0].length();

        int lux=n+1; int luy=m+1;
        int rdx=-1; int rdy=-1;
        
        for(int i=0; i<n; i++){
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        return new int[]{lux,luy,rdx,rdy};
    }
}