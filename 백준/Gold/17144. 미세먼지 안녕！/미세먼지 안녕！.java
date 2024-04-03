import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int T;
	static int[] machine;
	static int[][] map;
	static ArrayList<Point> list;

	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		machine = new int[2];
		int idx = 0;
		list = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					machine[idx++] = i;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			find();
			spread();
			rotate1(machine[0]);
			rotate2(machine[1]);
//			print();
		}
		System.out.println(find());
	}

	static void rotate1(int num) {
		// 반 시계
		for (int i = num - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}

		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j + 1];
		}

		for (int i = 0; i < num; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}

		for (int j = C - 1; j > 0; j--) {
			if (map[num][j - 1] == -1)
				map[num][j] = 0;
			else
				map[num][j] = map[num][j - 1];
		}
	}

	static void rotate2(int num) {
		// 시계
		for (int i = num + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}

		for (int j = 0; j < C - 1; j++) {
			map[R - 1][j] = map[R - 1][j + 1];
		}

		for (int i = R - 1; i > num; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		for (int j = C - 1; j > 0; j--) {
			if (map[num][j - 1] == -1)
				map[num][j] = 0;
			else
				map[num][j] = map[num][j - 1];
		}
	}

//	static void print() {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.printf("%2d ", map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("==================");
//	}

	static int find() {
		int total = 0;
		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1 && map[i][j] != 0) {
					list.add(new Point(i, j, map[i][j]));
					total += map[i][j];
				}
			}
		}
		return total;
	}

	static void spread() {
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);

			int cnt = p.size / 5;

			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
					map[ni][nj] += cnt;
					map[p.i][p.j] -= cnt;
				}
			}
		}

	}

	static class Point {
		int i;
		int j;
		int size;

		public Point(int i, int j, int size) {
			this.i = i;
			this.j = j;
			this.size = size;
		}
	}
}