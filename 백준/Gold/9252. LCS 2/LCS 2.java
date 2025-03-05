import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		if (str1.length() < str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}

		int N = str2.length();
		int M = str1.length();

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[N][M]);
		Stack<Character> stack = new Stack<Character>();
		if (dp[N][M] != 0) {
			int i = N;
			int j = M;
			while (i > 0 && j > 0) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					stack.add(str1.charAt(j - 1));
					i--;
					j--;
				} else if (dp[i - 1][j] >= dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}

			}
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.toString());
		}
	}
}