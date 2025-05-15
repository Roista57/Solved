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
		int K = Integer.parseInt(st.nextToken());

		Queue<Point> queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			queue.add(new Point(num, g, s, b));
		}
		int rank = 1;
		int count = 0;
		Point last = queue.peek();

		while (!queue.isEmpty()) {
			boolean flag = false;
			Point p = queue.poll();
			if (last.g == p.g) {
				if (last.s == p.s) {
					if (last.b == p.b) {
						count++;
					} else {
						flag = true;
					}
				} else {
					flag = true;
				}
			} else {
				flag = true;
			}
			if (flag) {
				rank += count;
				count = 1;
			}
			last = p;
			if (p.num == K) {
				System.out.println(rank);
				break;
			}
		}
	}

	static class Point implements Comparable<Point> {
		int num;
		int g;
		int s;
		int b;

		public Point(int num, int g, int s, int b) {
			this.num = num;
			this.g = g;
			this.s = s;
			this.b = b;
		}

		@Override
		public int compareTo(Point o) {
			if (o.g == g) {
				if (o.s == s) {
					return Integer.compare(o.b, b);
				}
				return Integer.compare(o.s, s);
			}
			return Integer.compare(o.g, g);
		}

		@Override
		public String toString() {
			return "Point [g=" + g + ", s=" + s + ", b=" + b + "]";
		}
	}
}