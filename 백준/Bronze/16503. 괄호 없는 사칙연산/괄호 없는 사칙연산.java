import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K1 = Integer.parseInt(st.nextToken());
		String O1 = st.nextToken();
		int K2 = Integer.parseInt(st.nextToken());
		String O2 = st.nextToken();
		int K3 = Integer.parseInt(st.nextToken());

		int ans1 = calc(calc(K1, O1, K2), O2, K3);
		int ans2 = calc(K1, O1, calc(K2, O2, K3));
		if(ans1 < ans2){
			System.out.println(ans1);
			System.out.println(ans2);
		}else{
			System.out.println(ans2);
			System.out.println(ans1);
		}
	}

	static int calc(int a, String o, int b){
		if(o.equals("+")){
			return a + b;
		}else if(o.equals("-")){
			return a - b;
		}else if(o.equals("*")){
			return a * b;
		}else{
			return a / b;
		}
	}
}