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
	static char[][] map;
	static boolean[][] visited;
	static int maxTime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		maxTime = 0;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					func(new Point(i, j, 0));
				}
			}
		}
		System.out.println(maxTime);
	}

	static void func(Point st) {
		int max = 0;
		visited = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(st);
		visited[st.i][st.j] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			max = Math.max(max, p.time);
			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 'L' && !visited[ni][nj]) {
					queue.add(new Point(ni, nj, p.time + 1));
					visited[ni][nj] = true;
				}
			}
		}
		maxTime = Math.max(max, maxTime);
	}

	static class Point {
		int i;
		int j;
		int time;

		public Point(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}

}