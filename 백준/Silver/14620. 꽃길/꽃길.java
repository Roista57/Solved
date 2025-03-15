import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] select;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		select = new boolean[N][N];
		min = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(0, 0);
		System.out.println(min);
	}

	static void func(int idx, int sum) {
		if (idx == 3) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!select[i][j]) {

					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni >= 0 && ni < N && nj >= 0 && nj < N && !select[ni][nj]) {
							cnt++;
						}
					}
					if (cnt == 4) {
						int cost = map[i][j];
						select[i][j] = true;
						for (int d = 0; d < 4; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							cost += map[ni][nj];
							select[ni][nj] = true;
						}
						func(idx + 1, sum + cost);

						select[i][j] = false;
						for (int d = 0; d < 4; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							select[ni][nj] = false;
						}
					}
				}
			}
		}
	}
}