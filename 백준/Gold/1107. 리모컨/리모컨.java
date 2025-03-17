import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] number;
	static int N;
	static Queue<Node> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		number = new boolean[10];
		Arrays.fill(number, true);
		N = Integer.parseInt(br.readLine()); // target
		queue = new PriorityQueue<Node>();
		int M = Integer.parseInt(br.readLine());
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				number[Integer.parseInt(st.nextToken())] = false;
			}
		}
		queue.add(new Node(100, Math.abs(N - 100)));
		func(0, "");
		Node node = queue.poll();
		System.out.println(node.len);
	}

	static void func(int idx, String num) {
		if (idx <= 6) {
			if (idx > 0) {
				int count = 0;
				int parse = Integer.parseInt(num);
				if (parse == 0) {
					count++;
				} else {
					count = (int) Math.log10(parse) + 1;
				}
				queue.add(new Node(parse, Math.abs(N - parse) + count));
			}

			for (int i = 0; i < 10; i++) {
				if (number[i]) {
					func(idx + 1, num + i);
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int number;
		int len;

		public Node(int number, int len) {
			this.number = number;
			this.len = len;
		}

		public int compareTo(Node o) {
			if (len > o.len) {
				return 1;
			} else if (len == o.len) {
				return number - o.number;
			} else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return number + ": " + len;
		}
	}
}