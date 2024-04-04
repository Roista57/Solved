import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] minTime;
	static int N;
	static final int M = 100000;
	static int K;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		minTime = new int[M + 1];
		Arrays.fill(minTime, Integer.MAX_VALUE);

		if (N > K) {
			System.out.println(N - K);
			for (int i = N; i >= K; i--) {
				System.out.print(i + " ");
			}
		} else {
			bfs(new Point(N, 0, new StringBuilder()));
		}
	}

	static void bfs(Point start) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point num = queue.poll();
				num.sb.append(num.X + " ");

				if (minTime[num.X] > num.time) {
					minTime[num.X] = num.time;
				} else
					continue;

				if (num.X == K && minTime[K] == num.time) {
					System.out.println(minTime[K]);
					System.out.println(num.sb.toString());
					return;
				}

				if ((num.X - 1) >= 0 && (num.X - 1) <= M) {
					queue.offer(new Point(num.X - 1, num.time + 1, new StringBuilder().append(num.sb.toString())));
				}
				if ((num.X + 1) >= 0 && (num.X + 1) <= M) {
					queue.offer(new Point(num.X + 1, num.time + 1, new StringBuilder().append(num.sb.toString())));
				}
				if ((num.X * 2) >= 0 && (num.X * 2) <= M) {
					queue.offer(new Point(num.X * 2, num.time + 1, new StringBuilder().append(num.sb.toString())));
				}
			}
		}
	}

	static class Point {
		int X;
		int time;
		StringBuilder sb;

		public Point(int x, int time, StringBuilder sb) {
			super();
			X = x;
			this.time = time;
			this.sb = sb;
		}
	}
}