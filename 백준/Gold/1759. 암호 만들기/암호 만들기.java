import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.UID;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l,c;
    static String[] arr;
    static String[] parentWord={"a","e","i","o","u"};
    static StringBuilder sb=new StringBuilder();
    static String[] encryt;
    static boolean[] parentWordCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        l=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        arr=new String[c];
        st=new StringTokenizer(br.readLine());
        String s="";
        for(int i=0; i<c; i++){
            arr[i]=st.nextToken();
        }
        Arrays.sort(arr);
        encryt=new String[l];
        comb(0,0,0,0);
        System.out.println(sb);
    }

    public static void comb(int idx, int start, int parentCnt, int childCnt){
        if(idx==l){
            if(parentCnt>=1&&childCnt>=2){
                for(String i:encryt){
                    sb.append(i);
                }
                sb.append("\n");
            }
            return;

        }

        for(int i=start; i<c; i++){
            encryt[idx]=arr[i];
            if(isParentWord(arr[i])){
                comb(idx+1, i+1, parentCnt+1, childCnt);
            }else{
                comb(idx+1, i+1, parentCnt, childCnt+1);

            }
        }
    }

    public static boolean isParentWord(String s){
        for(String p:parentWord){
            if(p.equals(s)) return true;
        }
        return false;
    }
}