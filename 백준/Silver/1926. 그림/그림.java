import java.awt.geom.QuadCurve2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;

	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	static int[][] map;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(new Point(i, j));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);

	}

	static void bfs(Point st) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(st);
		visited[st.i][st.j] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if (map[ni][nj] == 1 && !visited[ni][nj]) {
						queue.offer(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
			cnt++;
		}

		max = Math.max(max, cnt);

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