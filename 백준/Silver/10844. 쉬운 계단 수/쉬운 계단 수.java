import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger[][] dp = new BigInteger[N][10];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i][j] = BigInteger.valueOf(0);
			}
		}

		for (int i = 1; i < 10; i++) {
			dp[0][i] = BigInteger.valueOf(1);
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j - 1 >= 0)
					dp[i][j - 1] = dp[i][j - 1].add(dp[i - 1][j]);
				if (j + 1 < 10)
					dp[i][j + 1] = dp[i][j + 1].add(dp[i - 1][j]);
			}
		}

		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < 10; i++) {
			sum = sum.add(dp[N - 1][i]);
		}
		System.out.println(sum.mod(BigInteger.valueOf(1000000000)));
	}
}