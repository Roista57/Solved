import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 자리수, 마지막 숫자, 비트마스킹
		long[][][] dp = new long[N + 1][10][1024];

		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		// 결과적으로 0~9의 숫자가 모두 포함된 숫자들의 개수를 구하는 문제
		// 정확한 값을 가지고 갈 필요가 없음(마지막 숫자랑 어떤 숫자들을 포함하고 있는지만 알면 됨)
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int bit = 0; bit < (1 << 10); bit++) {
					if (dp[i][j][bit] == 0)
						continue;
					// 자리수를 하나 증가시키고 현재 마지막 숫자에서 1을 뺀 곳에 내가 가진 값을 보내줌
					if (j - 1 >= 0) {
						dp[i + 1][j - 1][bit | (1 << j - 1)] += dp[i][j][bit];
						dp[i + 1][j - 1][bit | (1 << j - 1)] %= 1000000000;
					}
					// 자리수를 하나 증가시키고 현재 마지막 숫자에서 1을 더한 곳에 내가 가진 값을 보내줌
					if (j + 1 <= 9) {
						dp[i + 1][j + 1][bit | (1 << j + 1)] += dp[i][j][bit];
						dp[i + 1][j + 1][bit | (1 << j + 1)] %= 1000000000;
					}
				}

			}
		}
		long ans = 0;
		for (int j = 0; j <= 9; j++) {
			ans += dp[N][j][1023];
		}
		ans %= 1000000000;
		System.out.println(ans);

	}
}