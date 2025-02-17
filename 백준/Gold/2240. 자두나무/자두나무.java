import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] list = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[T + 1][W + 1];
		
		int max = 0;

		for (int t = 1; t <= T; t++) {
			for (int w = 0; w <= W; w++) {
				if (w == 0) {
					if (list[t] == 1) {
						// 자두나무가 1번 자리에 있을 때
						// 앞: 사람이 1번 위치에서 온 경우, 뒤: 사람이 2번 자리에서 온 경우
						dp[t][w] = dp[t - 1][w] + 1;
					} else {
						// 자두나무가 2번 자리에 있을 때
						// 앞: 사람이 1번 위치에서 온 경우, 뒤: 사람이 2번 자리에서 온 경우
						dp[t][w] = dp[t - 1][w];
					}
				} else if (w % 2 == 0) {
					// 사람이 1번 자리에 있을 때
					if (list[t] == 1) {
						// 자두나무가 1번 자리에 있을 때
						// 앞: 사람이 1번 위치에서 온 경우, 뒤: 사람이 2번 자리에서 온 경우
						dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1] + 1);
					} else {
						// 자두나무가 2번 자리에 있을 때
						// 앞: 사람이 1번 위치에서 온 경우, 뒤: 사람이 2번 자리에서 온 경우
						dp[t][w] = Math.max(dp[t - 1][w], dp[t - 1][w - 1]);
					}
				} else {
					// 사람이 2번 자리에 있을 때
					if (list[t] == 2) {
						// 자두나무가 2번 자리에 있을 때
						// 앞: 사람이 2번 위치에서 온 경우, 뒤: 사람이 1번 자리에서 온 경우
						dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1] + 1);
					} else {
						// 자두나무가 1번 자리에 있을 때
						// 앞: 사람이 2번 위치에서 온 경우, 뒤: 사람이 1번 자리에서 온 경우
						dp[t][w] = Math.max(dp[t - 1][w], dp[t - 1][w - 1]);
					}
				}
				max = Math.max(max, dp[t][w]);
			}
//			System.out.println(t+": ["+list[t]+"]"+Arrays.toString(dp[t]));
		}
		System.out.println(max);
	}

}