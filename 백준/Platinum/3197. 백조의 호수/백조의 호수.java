import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };
	static Point[] node;
	static int[][] mapInt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		node = new Point[2];
		int cnt = 0;

		map = new char[R][C];
		mapInt = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(mapInt[i], Integer.MAX_VALUE);
		}
		boolean[][] visited = new boolean[R][C];
		Queue<Point> queue = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					node[cnt++] = new Point(i, j, 0);
					queue.add(new Point(i, j, 0));
					mapInt[i][j] = 0;
				}
				if (map[i][j] == '.') {
					queue.add(new Point(i, j, 0));
					mapInt[i][j] = 0;
				}
			}
		}
		// 처음에 부서질 얼음들의 위치
		int size = queue.size();
		while (--size >= 0) {
			Point p = queue.poll();
			visited[p.i][p.j] = true;
			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < R && nj >= 0 & nj < C && map[ni][nj] == 'X' && !visited[ni][nj]) {
					visited[ni][nj] = true;
					queue.add(new Point(ni, nj, 0));
				}
			}
		}

		// X를 찾음
		while (!queue.isEmpty()) {
			size = queue.size();
			while (--size >= 0) {
				int min = Integer.MAX_VALUE;
				Point p = queue.poll();
				visited[p.i][p.j] = true;

				for (int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if (ni >= 0 && ni < R && nj >= 0 & nj < C) {
						if (map[ni][nj] == 'X' && !visited[ni][nj]) {
							visited[ni][nj] = true;
							queue.add(new Point(ni, nj, 0));
						}
						min = Math.min(min, mapInt[ni][nj]);
					}
				}
				mapInt[p.i][p.j] = min + 1;
			}
		}

		visited = new boolean[R][C];
		queue = new PriorityQueue<>();
		queue.add(node[0]);
		visited[node[0].i][node[0].j] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.i == node[1].i && p.j == node[1].j) {
				System.out.println(p.cost);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < R && nj >= 0 & nj < C && !visited[ni][nj]) {
					visited[ni][nj] = true;
					queue.add(new Point(ni, nj, Math.max(p.cost, mapInt[ni][nj])));
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int i;
		int j;
		int cost;

		public Point(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return cost - o.cost;
		}

	}
}