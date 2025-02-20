import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] list = new int[N + 1];
		for (int i = 0; i < M; i++) {
			int hold = Integer.parseInt(br.readLine());
			list[hold] = 1;
		}

		long[] dp = new long[41];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 41; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int cnt = 0;
		long sum = 1;
		for (int i = 1; i < N + 1; i++) {
			if (list[i] == 1) {
				if(cnt != 0) sum *= dp[cnt];
				cnt = 0;
			} else {
				cnt++;
			}
		}
		if (cnt != 0)
			sum *= dp[cnt];
		System.out.println(sum);
	}

}