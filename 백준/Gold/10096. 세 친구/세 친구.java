import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char ch[];
    static int N;
 
    static boolean solve(char s1[], char s2[]) {
        int cnt = 0;
        for (int i = 0, j = 0; i < s1.length; i++, j++) {
            if (s1[i] != s2[j]) {
                if (cnt > 0)
                    return false;
                cnt++;
                i--;
            }
        }
 
        return true;
    }
 
    static void func() {
        if (N % 2 == 0) {
            System.out.println("NOT POSSIBLE");
            return;
        }
        char s1[] = new char[N / 2];
        char s2[] = new char[N / 2 + 1];
        char s3[] = new char[N / 2];
        char s4[] = new char[N / 2 + 1];
 
        System.arraycopy(ch, 0, s1, 0, N / 2);
        System.arraycopy(ch, N / 2, s2, 0, N / 2 + 1);
 
        System.arraycopy(ch, 0, s4, 0, N / 2 + 1);
        System.arraycopy(ch, N / 2 + 1, s3, 0, N / 2);
 
        boolean result2 = solve(s3, s4);
        boolean result1 = solve(s1, s2);
 
        if (result1 && result2) {
            String str1 = String.valueOf(s1);
            String str2 = String.valueOf(s3);
            if (str1.contains(str2))
                System.out.println(String.valueOf(s1));
            else
                System.out.println("NOT UNIQUE");
        } else if (!result1 && !result2)
            System.out.println("NOT POSSIBLE");
        else if (result1)
            System.out.println(String.valueOf(s1));
        else
            System.out.println(String.valueOf(s3));
 
    }
 
    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        ch = st.nextToken().toCharArray();
    }
 
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}