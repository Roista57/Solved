import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] list = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		int dp[][] = new int[N + 1][3];

		for (int i = 1; i < N + 1; i++) {
			// 선택을 안한 경우
			dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));

			// 선택을 한 경우
			dp[i][1] = dp[i - 1][2] + list[i]; // 현재 위치의 앞을 선택한 경우
			dp[i][2] = dp[i - 1][0] + list[i]; // 현재 위치의 앞을 건너뛴 경우
		}
//		for(int j=0;j<3;j++) {
//			for(int i=0;i<N+1;i++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}

		System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
	}
}