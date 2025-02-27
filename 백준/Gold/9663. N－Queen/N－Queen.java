import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] map;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		total = 0;
		func(0);
		System.out.println(total);
	}

	static void func(int idx) {
		if (idx == N - 1) {
			for (int j = 0; j < N; j++) {
				if (map[idx][j] == 0)
					total++;
			}
			return;
		}

		for (int j = 0; j < N; j++) {
			if (map[idx][j] == 0) {
				change(idx, j, 1);
//				for(int[] a : map) {
//					System.out.println(Arrays.toString(a));
//				}
//				System.out.println();
				func(idx + 1);
				change(idx, j, -1);
			}
		}
	}

	static void change(int x, int y, int num) {
		for (int w = 0; w < N; w++) {
			map[x][w] += num;
			map[w][y] += num;
			if (x + w < N && y + w < N) {
				map[x + w][y + w] += num;
			}
			if (x - w >= 0 && y - w >= 0) {
				map[x - w][y - w] += num;
			}
			if (x - w >= 0 && y + w < N) {
				map[x - w][y + w] += num;
			}
			if (x + w < N && y - w >= 0) {
				map[x + w][y - w] += num;
			}
		}
	}
}