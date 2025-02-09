import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dj = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int MAX = Integer.parseInt(br.readLine());
			int[][] map = new int[MAX][MAX];
			boolean[][] visited = new boolean[MAX][MAX];
			boolean flag = false;

			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			Point target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			Queue<Point> queue = new ArrayDeque<Point>();
			queue.add(start);
			visited[start.i][start.j] = true;
			int time = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				while (--size >= 0) {
					if(flag) continue;
					Point p = queue.poll();
					for (int d = 0; d < 8; d++) {
						int ni = p.i + di[d];
						int nj = p.j + dj[d];

						if (ni >= 0 && nj >= 0 && ni < MAX && nj < MAX && !visited[ni][nj]) {
							queue.add(new Point(ni, nj));
							visited[ni][nj] = true;
							if(ni == target.i && nj == target.j) {
								flag = true;
							}
						}
					}
				}
				time++;
				if (flag) break;
			}
			System.out.println(flag ? time : 0);
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
}