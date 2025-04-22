import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[10];
		Arrays.fill(dp, 1);
		for (int d = 0; d < N; d++) {
			for (int i = 1; i < 10; i++) {
				dp[i] = (dp[i - 1] + dp[i]) % 10007;
			}
		}
		System.out.println(dp[9]);
	}

}