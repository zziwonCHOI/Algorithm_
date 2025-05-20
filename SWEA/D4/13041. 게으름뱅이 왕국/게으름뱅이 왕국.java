import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static int n,k;
	static int[][] job;
	static int[] cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 int T=Integer.parseInt(br.readLine());
		 for(int t=1; t<=T; t++) {
			 st=new StringTokenizer(br.readLine());
			 n=Integer.parseInt(st.nextToken());
			 k=Integer.parseInt(st.nextToken());
			 
			 job=new int[n+1][2];
			 cnt=new int[k+1];
			 int jobCnt=k;
			 st=new StringTokenizer(br.readLine());
			 for(int i=1; i<=n; i++) {
				 int num=Integer.parseInt(st.nextToken());
				 job[i][0]=num;
				 cnt[num]++;
				 if(cnt[num]==1) {
					 jobCnt--;
				 }
			 }
			 
			 st=new StringTokenizer(br.readLine());
			 for(int i=1; i<=n; i++) {
				 job[i][1]=Integer.parseInt(st.nextToken());
			 }
			 Arrays.sort(job, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			 
			 long res=0;
			 for(int i=1; i<=n; i++) {
				 if(jobCnt!=0&& cnt[job[i][0]]>1) {
					 jobCnt--;
					 cnt[job[i][0]]--;
					 res+=job[i][1];
				 }
			 }
			 
			 System.out.println("#"+t+" "+res);
		 }
	}
}