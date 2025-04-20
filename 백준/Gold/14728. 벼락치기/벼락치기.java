import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][T + 1];

		Study[] list = new Study[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list[i] = new Study(k, s);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= T; j++) {
				if (j >= list[i].K) {
					dp[i][j] = Math.max(dp[i - 1][j], list[i].S + dp[i - 1][j - list[i].K]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][T]);

	}

	static class Study {
		int K;
		int S;

		public Study(int k, int s) {
			K = k;
			S = s;
		}
	}
}