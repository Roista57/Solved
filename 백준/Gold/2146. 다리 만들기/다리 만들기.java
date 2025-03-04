import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] map2;
	static boolean[][] visited;
	static int min;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		map2 = new int[N][N];
		visited = new boolean[N][N];
		min = Integer.MAX_VALUE;

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					func(new Point(i, j), ++num);
				}
			}
		}

//		for (int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					func2(new Point(i, j));
				}
			}
		}
		System.out.println(min);

	}

	static void func(Point s, int num) {
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(s);
		map[s.i][s.j] = num;
		visited[s.i][s.j] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					if (!visited[ni][nj] && map[ni][nj] == 1) {
						map[ni][nj] = num;
						queue.add(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
		}
	}

	static void func2(Point s) {
		boolean[][] visited = new boolean[N][N];
		Queue<Bridge> queue = new ArrayDeque<Bridge>();
		queue.add(new Bridge(s.i, s.j, 0));
		visited[s.i][s.j] = true;

		while (!queue.isEmpty()) {
			Bridge p = queue.poll();
			if (p.len > min)
				continue;
			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
					if (map[ni][nj] != 0) { // 섬인 경우
						if (map[ni][nj] != map[s.i][s.j]) { // 자기 섬이 아닌 경우
//							System.out.println("(" + s.i + ", " + s.j + ") >> (" + ni + ", " + nj + "): " + p.len);
							min = Math.min(min, p.len);
						}
					} else { // 바다인 경우
						queue.add(new Bridge(ni, nj, p.len + 1));
					}
					visited[ni][nj] = true;
				}
			}
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

	static class Bridge {
		int i;
		int j;
		int len;

		public Bridge(int i, int j, int len) {
			this.i = i;
			this.j = j;
			this.len = len;
		}
	}
}