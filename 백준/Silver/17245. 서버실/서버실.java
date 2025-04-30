import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new PriorityQueue<>();

		long total = 0;
		long sum = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				total += num;
			}
		}

		while (!queue.isEmpty()) {
			if (queue.peek() == 0) {
				queue.poll();
			} else {
				break;
			}
		}

		int time = 0;
		if (!queue.isEmpty()) {
			while (true) {
				time++;
				sum += queue.size();
//				System.out.println(time + " >> " + total + ": " + sum);
				if (sum >= (total + 1) / 2) {
					break;
				}
				while (!queue.isEmpty()) {
					if (queue.peek() == time) {
						queue.poll();
					} else {
						break;
					}
				}
//				System.out.println(queue.size());
			}
		}
		System.out.println(time);
	}
}