import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,r,c;
	static int cnt;
	public static void DivideSearch(int x, int y, int size) {
		if((r < x || r >= x + size || c < y || c >= y + size)) {
			cnt+=size*size;
			return;
		}
		if(size==1) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		int half=size/2;
		DivideSearch(x,y, half);
		DivideSearch(x, y+half, half);
		DivideSearch(x+half,y, half);
		DivideSearch(x+half,y+half, half);

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n][n];
		int num=0;
		cnt=0;
		DivideSearch(0,0,(int)Math.pow(2, n));
		
//		System.out.println(cnt);

	}

}