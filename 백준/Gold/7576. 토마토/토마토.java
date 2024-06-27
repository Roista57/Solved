import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
		int cnt = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (--size >= 0) {
				Point p = queue.poll();

				map[p.i][p.j] = 1;

				for (int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
						if (map[ni][nj] == 0 && !visited[ni][nj]) {
							queue.add(new Point(ni, nj));
							visited[ni][nj] = true;
						}
					}
				}
			}
			cnt++;
		}
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					flag = false;
				}
			}
		}
		if (flag) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}

	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "(" + i + ", " + j + ")";
		}

	}
}