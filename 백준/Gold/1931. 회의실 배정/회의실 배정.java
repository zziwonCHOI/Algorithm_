import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n][2];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[i][0]=a;
			arr[i][1]=b;
		}
		
		Arrays.sort(arr,(b1,b2)->{
			if(b1[1]==b2[1]) {
				return b1[0]-b2[0];
			}
			return b1[1]-b2[1];
		});
		
		int end=0;
		int cnt=0;
		for(int i=0; i<n; i++) {
			if(end<=arr[i][0]) {
				end=arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}