import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		for (int i = N - 1; i >= 0; i--) {
			int finish = list[i][0] + i;
			if (finish <= N) {
				dp[i] = Math.max(list[i][1] + dp[finish], dp[i + 1]);
			} else {
				dp[i] = dp[i + 1];
			}
		}
		System.out.println(dp[0]);
	}
}