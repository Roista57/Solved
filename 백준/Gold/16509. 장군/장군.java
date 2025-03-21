import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] di = { { -1, -2, -3 }, { -1, -2, -3 }, { 0, -1, -2 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 2, 3 },
			{ 0, -1, -2 }, { 0, 1, 2 } };
	static int[][] dj = { { 0, -1, -2 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 2, 3 }, { 0, 1, 2 }, { 0, -1, -2 },
			{ -1, -2, -3 }, { -1, -2, -3 } };
	static boolean[][] visited;

	static final int N = 10;
	static final int M = 9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean[N][M];

		StringTokenizer st = new StringTokenizer(br.readLine());
		Point sang = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		Point king = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(sang);
		visited[sang.i][sang.j] = true;

		boolean exit = false;
		int time = 0;

		while (!queue.isEmpty() && !exit) {
			int size = queue.size();
			while (--size >= 0) {
				Point p = queue.poll();

				if (p.i == king.i && p.j == king.j) {
					exit = true;
					System.out.println(time);
					break;
				}

				for (int d = 0; d < 8; d++) {
					boolean flag = true;
					for (int k = 0; k < 2; k++) {
						int ni = p.i + di[d][k];
						int nj = p.j + dj[d][k];

						if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
							flag = false;
						}

						if (ni == king.i && nj == king.j) {
							flag = false;
						}
					}
					if (flag) {
						int ni = p.i + di[d][2];
						int nj = p.j + dj[d][2];

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj]) {
							queue.add(new Point(ni, nj));
							visited[ni][nj] = true;
						}
					}
				}
			}
			time++;
		}
		if (!exit) {
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
	}
}