import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] list = new int[2][N];
			int[][] dp = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = list[0][0];
			dp[1][0] = list[1][0];

			for (int j = 1; j < N; j++) {
				dp[0][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + list[0][j]);
				dp[1][j] = Math.max(dp[1][j - 1], dp[0][j - 1] + list[1][j]);
			}
			System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		}
	}

}