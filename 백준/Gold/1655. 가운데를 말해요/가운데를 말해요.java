 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> minQ=new PriorityQueue<>();
        PriorityQueue<Integer> maxQ=new PriorityQueue<>(Collections.reverseOrder());

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        for(int i:list){
            //길이가 같으면 maxQ에 넣는다.
            if(minQ.size()== maxQ.size()){
                maxQ.add(i);
                if(minQ.size()!=0&&minQ.peek()<i) {
                    int min = minQ.poll();
                    int max = maxQ.poll();
                    minQ.add(max);
                    maxQ.add(min);
                }
            }else{
                minQ.add(i);
                if(maxQ.peek()>i){
                    int max=maxQ.poll();
                    int min=minQ.poll();
                    minQ.add(max);
                    maxQ.add(min);
                }
            }
            sb.append(maxQ.peek()).append('\n');
        }
        System.out.println(sb);
    }
}