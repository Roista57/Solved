import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = new int[3]; // -1, 0, 1
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(0, N, 0, N, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(ans[i]);
		}

	}

	static void func(int si, int ei, int sj, int ej, int n) {
		int num = map[si][sj];
		boolean flag = true;

		for (int i = si; i < ei; i++) {
			for (int j = sj; j < ej; j++) {
				if (num != map[i][j])
					flag = false;
			}
		}

		if (flag) {
			if (num == -1) {
				ans[0]++;
			} else if (num == 0) {
				ans[1]++;
			} else {
				ans[2]++;
			}
		} else {
			int cnt = n / 3;
			for (int i = si; i < ei; i += cnt) {
				for (int j = sj; j < ej; j += cnt) {
//					System.out.println(i + ", " + i + ", " + cnt + ", " + j + ", " + j + ", " + cnt + ", " + cnt);
					func(i, i + cnt, j, j + cnt, cnt);
				}
			}
		}
	}
}