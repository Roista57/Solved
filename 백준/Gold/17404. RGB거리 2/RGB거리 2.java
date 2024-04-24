import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] rgb;
	static int[][] cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			cost = new int[N][3];
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					// 처음에 R을 선택했을 때 마지막에 R이 나오는 경우가 없으니 마지막에 R이 나오는 것을 INF로 설정
					cost[N - 1][j] = Integer.MAX_VALUE;
				} else {
					cost[N - 1][j] = rgb[N - 1][j];
				}
			}
			for (int j = N - 2; j >= 0; j--) {
				cost[j][0] = Math.min(cost[j + 1][1], cost[j + 1][2]) + rgb[j][0];
				cost[j][1] = Math.min(cost[j + 1][0], cost[j + 1][2]) + rgb[j][1];
				cost[j][2] = Math.min(cost[j + 1][0], cost[j + 1][1]) + rgb[j][2];
			}
			min = Math.min(min, cost[0][i]); // 처음에 R을 선택했으니 그 값을 확인
		}
		System.out.println(min);
	}
}