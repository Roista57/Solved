import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] visited;
	static int N;
	static int M;
	static int K;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			visited = new boolean[850][850];
			list = new ArrayList<>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int size = Integer.parseInt(st.nextToken());
					if (size != 0) {
						list.add(new Point(0, i + 400, j + 400, size, 0, size));
					}
				}
			}

			Queue<Point> queue = new PriorityQueue<>();
			for (int i = 0; i < list.size(); i++) {
				queue.offer(list.get(i));
				visited[list.get(i).i][list.get(i).j] = true;
			}
			int time = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();

				while (--size >= 0) {
					Point p = queue.poll();
					if (p.time == p.size) {
						p.time++;
						p.num = time + 1;
						for (int d = 0; d < 4; d++) {
							int ni = p.i + di[d];
							int nj = p.j + dj[d];

							if (!visited[ni][nj]) {
								queue.offer(new Point(time + 1, ni, nj, p.size, 0, p.size));
								visited[ni][nj] = true;
							}
						}
						p.delete--;
						if (p.delete == 0)
							continue;
						queue.offer(p);
					} else if (p.time < p.size) {
						p.time++;
						p.num = time + 1;
						queue.offer(p);
					} else {
						p.time++;
						p.num = time + 1;
						p.delete--;
						if (p.delete == 0)
							continue;
						queue.offer(p);
					}
				}
				time++;
				if (time == K) {
					System.out.println("#" + tc + " " + queue.size());
					break;
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int num;
		int i;
		int j;
		int size;
		int time;
		int delete;

		public Point(int num, int i, int j, int size, int time, int delete) {
			super();
			this.num = num;
			this.i = i;
			this.j = j;
			this.size = size;
			this.time = time;
			this.delete = delete;
		}

		@Override
		public int compareTo(Point o) {
			if (num > o.num) {
				return 1;
			} else if (num == o.num) {
				if (size < o.size) {
					return 1;
				} else if (size == o.size) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}
}