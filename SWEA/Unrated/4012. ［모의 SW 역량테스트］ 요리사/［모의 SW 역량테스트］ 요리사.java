import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] taste;
	static int minDiff;
	static boolean[] selected;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			n=Integer.parseInt(br.readLine());
			taste=new int[n][n];
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					taste[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			minDiff=Integer.MAX_VALUE;
			selected=new boolean[n];
			num=new int[n/2];
			cook(0,0);
			System.out.println("#"+t+" "+minDiff);
		}
	}
	private static void cook(int cnt, int start) {
		if(cnt==n/2) {
			calTaste();
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(selected[i]) continue;
			selected[i]=true;
			num[cnt]=i;
			cook(cnt+1,	i+1);
			selected[i]=false;
		}
	}
	private static void calTaste() {
		int aSum=0;
		int bSum=0;

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				if(selected[i]&&selected[j]) {
					aSum+=taste[i][j];
				}else if(!selected[i]&&!selected[j]) {
					bSum+=taste[i][j];
				}
			}
		}
		int diff=Math.abs(aSum-bSum);
		minDiff=Math.min(diff,minDiff);
	}
	
}