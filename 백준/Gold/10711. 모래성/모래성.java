import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int H;
	static int W;
	static Queue<Point> queue;
	static boolean[][] visited;
	static int[][] water;
	static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		water = new int[H][W];
		visited = new boolean[H][W];
		queue = new ArrayDeque<Point>();

		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] != '.' && map[i][j] != '9') {
					queue.add(new Point(i, j));
				}
			}
		}
		int time = 0;
		int size = queue.size();
		while (--size >= 0) {
			Point p = queue.poll();
			for (int d = 0; d < 8; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] == '.') {
					water[p.i][p.j]++;
				}
			}
			if (water[p.i][p.j] >= map[p.i][p.j] - '0') {
				queue.add(p);
				visited[p.i][p.j] = true;
			}
		}
		while (!queue.isEmpty()) {
			int size2 = queue.size();
			while (--size2 >= 0) {
				Point p = queue.poll();
				for (int d = 0; d < 8; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if (ni >= 0 && ni < H && nj >= 0 && nj < W) {
						water[ni][nj]++;
						if (!visited[ni][nj] && map[ni][nj] != '.' && water[ni][nj] >= map[ni][nj] - '0') {
							queue.add(new Point(ni, nj));
							visited[ni][nj] = true;
						}
					}
				}
			}
			time++;
		}
		System.out.println(time);
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