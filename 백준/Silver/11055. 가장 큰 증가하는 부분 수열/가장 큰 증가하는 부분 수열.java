import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] list = new int[N];
		int[] dp = new int[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			dp[i] = list[i];

			for (int j = 0; j < i; j++) {
				if (list[i] > list[j]) {
					dp[i] = Math.max(dp[i], dp[j] + list[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}