import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		N = N.mod(new BigInteger("1500000"));

		int number = N.intValue();
		int[] dp = new int[1500000];
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
		}
		System.out.println(dp[number]);

//		int[] list = new int[10000000];
//		int[] temp = new int[1000001];
//		list[1] = 1;
//		for (int i = 2; i < list.length; i++) {
//			list[i] = (list[i - 1] + list[i - 2]) % 1000000;
//			if (temp[list[i]] == 0)
//				temp[list[i]] = i;
//		}
//		int max = 0;
//		for (int i = 0; i < temp.length; i++) {
//			max = Math.max(max, temp[i]);
//		}
//		System.out.println(max);

	}
}