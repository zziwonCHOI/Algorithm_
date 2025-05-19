import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static int n,k;
	static int[][] job;
	static int[] checked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			job=new int[n+1][2];//0: i번째 사람이 선택한 일, 1:i번째 사람을 설득하는데 걸리는 시간 
			checked=new int[k+1]; //i번째 일을 하는 사람이 몇명인지 기록
			int cnt=k; //총 해야하는 일의 개수 
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<n+1;i++) {
				job[i][0]=Integer.parseInt(st.nextToken());
				checked[job[i][0]]++;
				if(checked[job[i][0]]==1) { //i번째 일을 하는 사람이 생기면 해야하는 일 개수 줄이기 
					cnt--;
				}
			}
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				job[i][1]=Integer.parseInt(st.nextToken());
			}
			
			//입력 받은 값을 설득 시간 기준으로 오름차순 정렬
			Arrays.sort(job, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			
			long res=0;
			for(int i=1; i<n+1; i++) {
				//동일한 일을 하려는 사람이 여러명 이면서, 해야할 일의 개수가 남아 있다면 
				if(checked[job[i][0]]>1&&cnt!=0) {
					res+=job[i][1]; //설득 시간이 제일 짧은 사람을 설득해서 해야할 일 1개 줄이기
					checked[job[i][0]]--;
					cnt--;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}