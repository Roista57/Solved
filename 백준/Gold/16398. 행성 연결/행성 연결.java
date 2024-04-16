import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0, 0));
		long total = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (visited[node.to])
				continue;

			visited[node.to] = true;
			total += node.weight;

			for (int i = 0; i < N; i++) {
				if (node.to != i && !visited[i]) {
					queue.offer(new Node(i, map[i][node.to]));
				}
			}
		}
		System.out.println(total);
	}

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
	}
}