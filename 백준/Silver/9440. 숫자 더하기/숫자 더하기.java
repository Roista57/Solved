import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		Queue<Integer> queue = new PriorityQueue<Integer>();
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			for (int i = 0; i < N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int zero = 0;

			while (queue.peek() == 0) {
				queue.poll();
				zero++;
			}

			String A = "" + queue.poll();
			String B = "" + queue.poll();

			for (int i = 0; i < zero; i++) {
				queue.add(0);
			}

			int cnt = 0;
			while (!queue.isEmpty()) {
				if (cnt % 2 == 0) {
					A += queue.poll();
				} else {
					B += queue.poll();
				}
				cnt++;
			}
			System.out.println(Integer.parseInt(A) + Integer.parseInt(B));
		}
	}
}