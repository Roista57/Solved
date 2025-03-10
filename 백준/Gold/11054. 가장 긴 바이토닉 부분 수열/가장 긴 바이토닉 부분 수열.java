import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][2];
		dp[0][0] = 1;
		dp[0][1] = 1;

		int max = 1;

		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (list[i] > list[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
					dp[i][1] = Math.max(dp[i][1], 1);
				} else if (list[i] == list[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0]);
					dp[i][1] = Math.max(dp[i][1], 1);
				} else {
					dp[i][0] = Math.max(dp[i][0], 1);
					dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0], dp[j][1]) + 1);
				}
				max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
			}
		}
		System.out.println(max);
	}
}