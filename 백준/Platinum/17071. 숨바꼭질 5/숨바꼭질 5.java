import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 수빈이의 위치
	static int K; // 동생의 위치
	static final int MAX = 500000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(new Point(N, 0));
	}

	static void bfs(Point start) {
		int time = 0;
		boolean[][] visited = new boolean[2][MAX + 1];
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point num = queue.poll();

				if (K > MAX)
					continue;

				if (num.time % 2 == 0) {
					if (visited[0][num.X])
						continue;
					else
						visited[0][num.X] = true;
				} else {
					if (visited[1][num.X])
						continue;
					else
						visited[1][num.X] = true;
				}

				if (time % 2 == 0) {
					if (visited[0][K]) {
						System.out.println(time);
						return;
					}
				} else {
					if (visited[1][K]) {
						System.out.println(time);
						return;
					}
				}

				if ((num.X - 1) >= 0 && (num.X - 1) <= MAX) {
					queue.offer(new Point(num.X - 1, num.time + 1));
				}
				if ((num.X + 1) >= 0 && (num.X + 1) <= MAX) {
					queue.offer(new Point(num.X + 1, num.time + 1));
				}
				if ((num.X * 2) >= 0 && (num.X * 2) <= MAX) {
					queue.offer(new Point(num.X * 2, num.time + 1));
				}
			}
			time++;
			K += time;
		}

		System.out.println("-1");
	}

	static class Point {
		int X;
		int time;

		public Point(int x, int time) {
			X = x;
			this.time = time;
		}
	}
}