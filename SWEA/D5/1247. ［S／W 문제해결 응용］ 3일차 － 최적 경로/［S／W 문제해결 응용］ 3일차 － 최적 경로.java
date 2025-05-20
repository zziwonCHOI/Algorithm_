import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] company;
	static int[][] home;
	static int[][] customer;
	static int[] num;
	static boolean[] selected;
	static int minDis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			n=Integer.parseInt(br.readLine());
			company=new int[1][2];
			home=new int[1][2];
			customer=new int[n][2];
			
			st=new StringTokenizer(br.readLine());
			company[0][0]=Integer.parseInt(st.nextToken());
			company[0][1]=Integer.parseInt(st.nextToken());
			home[0][0]=Integer.parseInt(st.nextToken());
			home[0][1]=Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				customer[i][0]=Integer.parseInt(st.nextToken());
				customer[i][1]=Integer.parseInt(st.nextToken());
			}
			
			num=new int[n];
			selected=new boolean[n];
			minDis=Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+t+" "+minDis);
		}
	}
	public static void perm(int cnt) {
		if(cnt==n) {
			calDis(num);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(selected[i]) continue;
			selected[i]=true;
			num[cnt]=i;
			perm(cnt+1);
			selected[i]=false;
		}
	}

	public static void calDis(int[] nums) {
		int dis=0;
		dis+=Math.abs(company[0][0]-customer[nums[0]][0])+Math.abs(company[0][1]-customer[nums[0]][1]);

		for(int i=0; i<n-1; i++) {
			dis+=Math.abs(customer[num[i]][0]-customer[num[i+1]][0])+Math.abs(customer[num[i]][1]-customer[num[i+1]][1]);
		}
		dis+=Math.abs(home[0][0]-customer[nums[n-1]][0])+Math.abs(home[0][1]-customer[nums[n-1]][1]);

		minDis=Math.min(minDis, dis);
	}
}