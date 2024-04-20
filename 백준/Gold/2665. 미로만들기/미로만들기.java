import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		bfs();
	}

	// 0은 검은색, 1은 흰색
	static void bfs() {
		Queue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.i == N - 1 && p.j == N - 1) {
				System.out.println(p.total);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
					visited[ni][nj] = true;
					if (map[ni][nj] == 1) {
						queue.offer(new Point(ni, nj, p.total)); // 흰색 지나감
					} else {
						queue.offer(new Point(ni, nj, p.total + 1)); // 검은색 지나감
					}
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int i;
		int j;
		int total;

		public Point(int i, int j, int total) {
			this.i = i;
			this.j = j;
			this.total = total;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(total, o.total);
		}
	}
}