import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static boolean[] visited;

	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { -1, 1, 1, -1 };

	static Point start;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[101];
					start = new Point(i, j);
					dfs(new Point(i, j), 0, 0);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	static void dfs(Point p, int cnt, int state) {
//		System.out.print(map[p.i][p.j] + "(" + p.i + ", " + p.j + ") ");
		if (cnt != 0 && p.i == start.i && p.j == start.j) {
//			System.out.println("나왔다");
			max = Math.max(max, cnt);
			return;
		}

		if (state == 4)
			return;

		int ni = p.i + di[state];
		int nj = p.j + dj[state];
		if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[map[ni][nj]]) {
			visited[map[ni][nj]] = true;
			dfs(new Point(ni, nj), cnt + 1, state);
			dfs(new Point(ni, nj), cnt + 1, state + 1);
			visited[map[ni][nj]] = false;
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