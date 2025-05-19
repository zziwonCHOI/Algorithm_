import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] price;
	static int[] schedule;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			price=new int[4];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<4; i++) {
				price[i]=Integer.parseInt(st.nextToken());
			}
			schedule=new int[12];
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				schedule[i]=Integer.parseInt(st.nextToken());
			}
			min=price[3];
			calCost(0,0);
			System.out.println("#"+t+" "+min);
				
		}
	}
	private static void calCost(int month, int sum) {
		if(month>=12) {
			min=Math.min(min, sum);
			return;
		}
		
		if(schedule[month]==0) {
			calCost(month+1, sum);
		}else {
			calCost(month+1, sum+schedule[month]*price[0]);
			calCost(month+1, sum+price[1]);
			calCost(month+3, sum+price[2]);
		}
		
	}
}