import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int k;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { -1, 0, +1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int w = 0; w < k; w++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			for (int i = b; i < d; i++) {
				for (int j = a; j < c; j++) {
					map[i][j] = 1;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					list.add(func(new Point(i, j)));
					cnt++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for (int a : list) {
			System.out.print(a + " ");
		}
	}

	static int func(Point start) {
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(start);

		int cnt = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			cnt++;
			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni >= 0 && nj >= 0 && ni < N && nj < M && !visited[ni][nj] && map[ni][nj] == 0) {
					visited[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
			}
		}
		return cnt;
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