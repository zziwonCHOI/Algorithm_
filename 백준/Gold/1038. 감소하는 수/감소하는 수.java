import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());


        if(n<=10){
            System.out.println(n);
            return;
        }else if(n>=1023){
            System.out.println(-1);
            return;
        }
        for(int i=0; i<10; i++){
            search(1, i); //해당 숫자가 들어가는 자리와 그 전에 만들어둔 수를 매개변수로 받는 함수 재귀로 구현 
        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }

    
    public static void search(int idx, long l){
        if(idx>10) return; //자리수가 10을 초과하면 더 이상 생성하지 않는다.
        list.add(l); //감소하는 수를 리스트에 추가
        for(int i=0; i<l%10;i++){
            search(idx+1, l*10+i); //현재 숫자 끝에 i를 추가해서 다시 숫자를 만든다.
        }
    }
}