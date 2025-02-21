import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			dp[i] = list[i];
			for (int j = 0; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
			}
		}
		System.out.println(dp[N]);
	}

}