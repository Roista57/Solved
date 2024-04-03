import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
	static long[][] score;
	static long cnt;

	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = 0;

		map = new int[M][N];
		score = new long[M][N];
		
		for(int i=0;i<M;i++) {
			Arrays.fill(score[i], -1);
		}
		

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		score[0][0] = 1;
//		bfs(new Point(0, 0, map[0][0]));
//		System.out.println(score[M - 1][N - 1]);

		System.out.println(dfs(new Point(0, 0, map[0][0])));
//		System.out.println(cnt);
	}

	static void bfs(Point start) {
		Queue<Point> queue = new PriorityQueue<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (score[p.i][p.j] != 0 && p.i != 0 && p.j != 0)
				continue;

			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < M && nj >= 0 && nj < N) {
					if (map[p.i][p.j] > map[ni][nj]) {
						queue.offer(new Point(ni, nj, map[ni][nj]));
					} else if (map[p.i][p.j] < map[ni][nj]) {
						score[p.i][p.j] += score[ni][nj];
					}
				}
			}
		}
	}

	static long dfs(Point p) {
		long total = 0;
		if (p.i == M - 1 && p.j == N - 1) {
			return 1;
		}

		cnt++;
		if (score[p.i][p.j] != -1) {
			return score[p.i][p.j];
		}
		
		for (int d = 0; d < 4; d++) {
			int ni = p.i + di[d];
			int nj = p.j + dj[d];

			if (ni >= 0 && ni < M && nj >= 0 && nj < N) {
				if (map[p.i][p.j] > map[ni][nj]) {
					if(score[ni][nj] != -1) {
						total += score[ni][nj];
					}else {
						total += dfs(new Point(ni, nj));
					}
				}
			}
		}
		score[p.i][p.j] = total;
		return total;
	}

	static class Point implements Comparable<Point> {
		int i;
		int j;
		int size;

		public Point(int i, int j, int size) {
			this.i = i;
			this.j = j;
			this.size = size;
		}

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			if (size < o.size)
				return 1;
			else if (size == o.size)
				return 0;
			else
				return -1;
		}
	}
}