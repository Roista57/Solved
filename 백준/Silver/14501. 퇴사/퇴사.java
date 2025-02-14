import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] list = new int[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken()); // 상담 종료에 걸리는 날짜
			list[i][1] = Integer.parseInt(st.nextToken()); // 비용
		}

		int[] dp = new int[N + 1];
		for (int i = N - 1; i >= 0; i--) {
			int finishDay = i + list[i][0];
			if (finishDay <= N) {
				dp[i] = Math.max(list[i][1] + dp[finishDay], dp[i + 1]); // 이 부분이 어렵네
			} else {
				dp[i] = dp[i + 1];
			}
		}
		System.out.println(dp[0]);
	}
}