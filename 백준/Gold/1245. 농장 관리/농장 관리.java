import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int[] di = { -1, -1, -1, 0, +1, +1, +1, 0 };
	static int[] dj = { -1, 0, +1, +1, +1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

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
				if (map[i][j] != 0 && !visited[i][j]) {
					if (bfs(new Point(i, j))) {
//						System.out.println(i + ", " + j);
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);

	}

	static boolean bfs(Point start) {
		boolean result = true;
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.i][start.j] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 8; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if (map[p.i][p.j] < map[ni][nj]) {
						result = false;
					} else if (map[p.i][p.j] == map[ni][nj] && !visited[ni][nj]) {
						queue.offer(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
		}
		return result;
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