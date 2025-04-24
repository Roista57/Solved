import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] list = new Point[N];
		double sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			long A = Long.parseLong(st.nextToken());
			list[i] = new Point(X, A);
			sum += A;
		}

		Arrays.sort(list);
		long mid = Math.round(sum / 2);
		long temp = 0;
		for (int i = 0; i < N; i++) {
			if (temp + list[i].a < mid) {
				temp += list[i].a;
			} else {
				System.out.println(list[i].x);
				break;
			}
		}
	}

	static class Point implements Comparable<Point> {
		int x;
		long a;

		public Point(int x, long a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Point o) {
			return x - o.x;
		}
	}
}