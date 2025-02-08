import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Point start = new Point(0, 0);
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(start);

		int time = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (--size >= 0) {
				Point p = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if (ni >= 0 && nj >= 0 && ni < N && nj < M && !visited[ni][nj] && map[ni][nj] == 1 && !flag) {
						if (ni == N - 1 && nj == M - 1)
							flag = true;
						queue.add(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
			time++;
			if (flag)
				break;
		}
		System.out.println(time);
	}
}

class Point {
	int i;
	int j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}