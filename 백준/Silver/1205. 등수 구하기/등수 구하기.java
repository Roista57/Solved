import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long number = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Queue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(number, 1));
		if (N != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				queue.add(new Point(Long.parseLong(st.nextToken()), 0));
			}
		}
		long last = Long.MAX_VALUE;
		int rank = 1;
		int total = 0;
		int cnt = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (last > p.num) {
				rank += cnt;
				cnt = 1;
			} else if (last == p.num) {
				cnt++;
			}
			last = p.num;
			if (p.cnt == 1) {
				break;
			}
			total++;
		}
		System.out.println(total < P ? rank : -1);

	}

	static class Point implements Comparable<Point> {
		long num;
		int cnt;

		public Point(long num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if (o.num == num) {
				return cnt - o.cnt;
			}
			return Long.compare(o.num, num);
		}

	}
}