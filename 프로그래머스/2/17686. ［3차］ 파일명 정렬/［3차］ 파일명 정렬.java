import java.util.ArrayList;
import java.util.Collections;


class Solution {
    static ArrayList<FileName> list;
  
    public String[] solution(String[] files) { 
        String[] answer=new String[files.length];
        list=new ArrayList<>();
        for(int i=0; i<files.length; i++){
            slice(files[i],i);
        }
        
        //File 클래스에서 비교 함수 필요.
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++){
            FileName l=list.get(i);
            answer[i]=files[l.idx];
        }
        return answer;
    }
    
    public static void slice(String cur, int idx){
    String head="";
    String number="";
    
    char[] arr=cur.toCharArray();
    for(int i=0; i<cur.length(); i++){
        if(Character.isDigit(arr[i])){
            break;
        }
        head+=arr[i];
    }
    
    for(int i=head.length(); i<cur.length(); i++){
        if(!Character.isDigit(arr[i])){
            break;
        }
        
        number+=arr[i];
    }
    
    list.add(new FileName(head, number, idx));
}

public static class FileName implements Comparable<FileName>{
    String head;
    String number;
    int idx;
    
    public FileName(String head, String number, int idx){
        this.head=head;
        this.number=number;
        this.idx=idx;
        }
    @Override
    public int compareTo(FileName other){
        int headCompare=this.head.toLowerCase().compareTo(other.head.toLowerCase());
        if(headCompare!=0) return headCompare;
        
        int num1=Integer.parseInt(this.number);
        int num2=Integer.parseInt(other.number);
        if(num1!=num2) return num1-num2;
        
        return this.idx-other.idx;
        }
    }
    
}

