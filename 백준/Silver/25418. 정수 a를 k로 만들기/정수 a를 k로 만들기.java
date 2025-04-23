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

		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 1000001;
		boolean[] visited = new boolean[max];

		Queue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(A, 0));
		visited[A] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.num == K) {
				System.out.println(p.time);
				break;
			}
			if (max > (p.num * 2) && !visited[p.num * 2]) {
				queue.add(new Point(p.num * 2, p.time + 1));
				visited[p.num * 2] = true;
			}

			if (max > (p.num + 1) && !visited[p.num + 1]) {
				queue.add(new Point(p.num + 1, p.time + 1));
				visited[p.num + 1] = true;
			}
		}
	}

	static class Point implements Comparable<Point> {
		int num;
		int time;

		public Point(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return time - o.time;
		}
	}
}