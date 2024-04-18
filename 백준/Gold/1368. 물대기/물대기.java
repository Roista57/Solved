import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static int[] cost;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<Edge>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		edges = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}

		cost = new int[N];
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			edges[i].add(new Edge(i, i, cost[i]));
		}

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (i == j)
					Integer.parseInt(st.nextToken());
				else {
					int weight = Integer.parseInt(st.nextToken());
					edges[i].add(new Edge(i, j, weight));
					edges[j].add(new Edge(j, i, weight));
				}
			}
		}

		int total = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			queue.offer(new Edge(i, i, cost[i]));
		}

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (visited[edge.to])
				continue;
//			System.out.println(edge);
			visited[edge.to] = true;
			total += Math.min(edge.weight, cost[edge.to]);

			for (Edge next : edges[edge.to]) {
				if (!visited[next.to])
					queue.offer(next);
			}

		}
		System.out.println(total);
//		System.out.println(Arrays.toString(visited));

	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}
}