import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static ArrayList<Integer> value;
	static ArrayList<Character> operator;
	static int max;
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		char[] input=br.readLine().toCharArray();
		
		value=new ArrayList<Integer>();
		operator=new ArrayList<Character>();
		
		for(int i=0; i<n; i++) {
			if(Character.isDigit(input[i])) {
				value.add(input[i]-'0');
			}else {
				operator.add(input[i]);
			}
		}
		
		max=Integer.MIN_VALUE;
		dfs(value.get(0),0);
		
		System.out.println(max);

	}
	
	public static int cal(char op, int a, int b) {
		switch (op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		
		}
		return -1;
	}
	
	
	
	public static void dfs(int result, int opIdx) {
		if(opIdx>=operator.size()) {
			max=Math.max(result, max);
			return;
		}
		
		//1. 괄호를 사용하지 않고 연산 진행 
		int res1=cal(operator.get(opIdx),result,value.get(opIdx+1));
		dfs(res1,opIdx+1);
		
		//괄호를 사용하여 연산(다음 연산을 먼저 수행) 
		if(opIdx+1<operator.size()) {//다음 연산자가 남아있어야 괄효 사용 가능 
			//괄호 연산을 먼저 수행 
			int res2=cal(operator.get(opIdx+1),value.get(opIdx+1),value.get(opIdx+2));
			int combineResult=cal(operator.get(opIdx),result,res2);
			dfs(combineResult,opIdx+2);//괄호를 사용하는 경우는 연산자를 2개 사용하기 때문에 2를 더한다. 
		}
	}


}
