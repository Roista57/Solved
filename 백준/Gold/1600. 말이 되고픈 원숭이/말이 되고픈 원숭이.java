import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static int[][][] visited;
	static boolean[][][] visited2;

	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	static int[] hi = { -2, -2, -1, -1, 2, 2, 1, 1 };
	static int[] hj = { -1, 1, -2, 2, -1, 1, -2, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new int[K + 1][H][W];

		for (int k = 0; k <= K; k++) {
			for (int i = 0; i < H; i++) {
				Arrays.fill(visited[k][i], -1);
			}
			visited[k][0][0] = 0;
		}

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(new Point(0, 0, 0));

		int min = Integer.MAX_VALUE;
		for (int k = 0; k <= K; k++) {
			if (visited[k][H - 1][W - 1] != -1) {
				min = Math.min(min, visited[k][H - 1][W - 1]);
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
	}

	static void bfs(Point start) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		int time = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point p = queue.poll();

				for (int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] != 1) {
						if (visited[p.cnt][ni][nj] > time || visited[p.cnt][ni][nj] == -1) {
							visited[p.cnt][ni][nj] = time;
							queue.offer(new Point(ni, nj, p.cnt));
						}
					}
				}
				if (p.cnt < K) {
					for (int d = 0; d < 8; d++) {
						int ni = p.i + hi[d];
						int nj = p.j + hj[d];

						if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] != 1) {
							if (visited[p.cnt + 1][ni][nj] > time || visited[p.cnt + 1][ni][nj] == -1) {
								visited[p.cnt + 1][ni][nj] = time;
								queue.offer(new Point(ni, nj, p.cnt + 1));
							}
						}
					}
				}
			}
//			System.out.println("time: " + time + " ============================");
//			for (int k = 0; k <= K; k++) {
//				System.out.println("기술 " + k + "번 사용");
//				for (int i = 0; i < H; i++) {
//					for (int j = 0; j < W; j++) {
//						System.out.printf("%2d ", visited[k][i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("-------------------------");
//			}
			time++;
		}
	}

	static class Point {
		int i;
		int j;
		int cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}