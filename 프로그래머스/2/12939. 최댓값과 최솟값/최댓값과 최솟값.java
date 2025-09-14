class Solution {
    public String solution(String s) {
        
        String[] parts=s.split(" ");
        
        int min=Integer.parseInt(parts[0]);
        int max=Integer.parseInt(parts[0]);
        
        for(String part:parts){
            int num=Integer.parseInt(part);
            if(num<min) min=num;
            if(num>max) max=num;
        }
        
        return min+" "+max;
    }
}