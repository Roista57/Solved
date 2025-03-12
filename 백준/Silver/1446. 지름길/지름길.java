import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] dp = new int[D + 1];
		for (int i = 0; i <= D; i++) {
			dp[i] = i;
		}

		int[][] list = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			int start = list[i][0];
			int end = list[i][1];
			int cost = list[i][2];

			if (start < D && end <= D) {
				dp[end] = Math.min(dp[end], dp[start] + cost);
				for (int j = end + 1; j <= D; j++) {
					dp[j] = Math.min(dp[j], dp[j - 1] + 1);
				}
			}
		}

		System.out.println(dp[D]);
	}
}