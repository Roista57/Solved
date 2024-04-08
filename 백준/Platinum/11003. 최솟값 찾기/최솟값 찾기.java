import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static Node[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		list = new Node[N];

		st = new StringTokenizer(br.readLine());
		Queue<Node> queue = new PriorityQueue<>();
		int start = 0;
		int end = 0;
		StringBuilder sb = new StringBuilder();
		while (end < N) {
			queue.offer(new Node(end, Integer.parseInt(st.nextToken())));
			while (queue.peek().num < start) {
				queue.poll();
			}
			sb.append(queue.peek().size + " ");
			if (start + (L - 1) > end) {
				end++;
			} else {
				start++;
				end++;
			}

		}
		System.out.println(sb.toString());
	}

	static class Node implements Comparable<Node> {
		int num;
		int size;

		public Node(int num, int size) {
			this.num = num;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(size, o.size);
		}
	}
}