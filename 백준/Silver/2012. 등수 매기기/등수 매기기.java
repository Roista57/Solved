import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> list = new ArrayDeque<Integer>();
		int[] rank = new int[500001];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
			rank[i + 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			if (rank[list.peek()] != 0) {
				rank[list.peek()] = 0;
				list.poll();
			} else {
				list.add(list.peek());
				list.poll();
			}
		}

		int cnt = 1;
		Queue<Integer> queue = new PriorityQueue<Integer>(list);
		while (!queue.isEmpty()) {
			if (rank[cnt] == 1) {
				sum += Math.abs(queue.peek() - cnt);
				queue.poll();
			}
			cnt++;
		}
		System.out.println(sum);
	}
}