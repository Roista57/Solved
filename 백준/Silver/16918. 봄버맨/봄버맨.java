import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] di = { -1, 0, +1, 0 };
		int[] dj = { 0, +1, 0, -1 };

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		int time = 0;
		for (int i = 0; i < R; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == 'O') {
					map[i][j] = 2;
				}
			}
		}

		time++;
		if (time < N) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != -1) {
						map[i][j]--;
					}
				}
			}
		}
		Queue<Point> queue = new ArrayDeque<Point>();
		while (time < N) {
			time++;

			if (time % 2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == -1) {
							map[i][j] = 3;
						}
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == 0) {
							map[i][j] = -1;
							queue.add(new Point(i, j));
						}
					}
				}

				while (!queue.isEmpty()) {
					Point p = queue.poll();
					for (int d = 0; d < 4; d++) {
						int ni = p.i + di[d];
						int nj = p.j + dj[d];
						if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
							map[ni][nj] = -1;
						}
					}
				}

			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != -1) {
						map[i][j]--;
					}
				}
			}
//			System.out.println("==========================");
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					if (map[i][j] == -1) {
//						System.out.print('.');
//					} else {
//						System.out.print('O');
//					}
//				}
//				System.out.println();
//			}
//			System.out.println("---------------------------");
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) {
					System.out.print('.');
				} else {
					System.out.print('O');
				}
			}
			System.out.println();
		}
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}