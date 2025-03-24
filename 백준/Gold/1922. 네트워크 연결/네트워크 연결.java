import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<Node>[] list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Node>();
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, cost));
			list[b].add(new Node(a, cost));
		}

		boolean[] visited = new boolean[N + 1];
		Queue<Node> queue = new PriorityQueue<Node>();
		int sum = 0;
		queue.add(new Node(1, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (visited[node.to])
				continue;

			visited[node.to] = true;
			sum += node.cost;
			for (Node no : list[node.to]) {
				queue.add(no);
			}
		}
		System.out.println(sum);
	}

	static class Node implements Comparable<Node> {
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}

}