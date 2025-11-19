import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i=1;i<=K;i++){
			// System.out.println(reverse(N*i));
			max = Math.max(max, reverse(N*i));
		}
		System.out.println(max);
	}

	static int reverse(int num){
		int ans = 0;
		while(num != 0){
			ans += num % 10;
			num /= 10;
			if(num != 0) ans *= 10;
		}
		return ans;
	}
}