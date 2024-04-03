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

//		bfs(new Point(N, 0, new ArrayList<>()));
		bfs(new Point(N, 0));
		System.out.println(minTime[K]);
		System.out.println(cnt);
	}

	static void bfs(Point start) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point num = queue.poll();
//				ArrayList<Integer> temp = new ArrayList<>();
//				for (int i = 0; i < num.list.size(); i++) {
//					temp.add(num.list.get(i));
//				}
//				temp.add(num.X);

				if (minTime[num.X] > num.time) {
					minTime[num.X] = num.time;
				} else {
					if (num.time > minTime[num.X]) {
						continue;
					}
//					if(num.X == K && minTime[K] == num.time) {
//						System.out.println("[1]"+temp.toString());
//						cnt++;
//					}
				}

				if (num.X == K && minTime[K] == num.time) {
//					System.out.println("[2]"+temp.toString());
					cnt++;
					continue;
				}

//				if ((num.X - 1) >= 0 && (num.X - 1) <= M) {
//					queue.offer(new Point(num.X - 1, num.time + 1, temp));
//				}
//				if ((num.X + 1) >= 0 && (num.X + 1) <= M) {
//					queue.offer(new Point(num.X + 1, num.time + 1, temp));
//				}
//				if ((num.X * 2) >= 0 && (num.X * 2) <= M) {
//					queue.offer(new Point(num.X * 2, num.time + 1, temp));
//				}

				if ((num.X - 1) >= 0 && (num.X - 1) <= M) {
					queue.offer(new Point(num.X - 1, num.time + 1));
				}
				if ((num.X + 1) >= 0 && (num.X + 1) <= M) {
					queue.offer(new Point(num.X + 1, num.time + 1));
				}
				if ((num.X * 2) >= 0 && (num.X * 2) <= M) {
					queue.offer(new Point(num.X * 2, num.time + 1));
				}
			}
//			System.out.println(time + ": " + minTime[K]);
			time++;
		}
	}

	static class Point {
		int X;
		int time;
//		ArrayList<Integer> list;

//		public Point(int x, int time, ArrayList<Integer> list) {
//			X = x;
//			this.time = time;
//			this.list = list;
//		}

		public Point(int x, int time) {
			X = x;
			this.time = time;
		}
	}
}