import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;

	static int[] powerPlant;
	static boolean[] visited;
	static ArrayList<Edge>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		powerPlant = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			powerPlant[i] = Integer.parseInt(st.nextToken());
		}

		edges = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
			edges[to].add(new Edge(from, weight));
		}

		int total = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			queue.offer(new Edge(powerPlant[i], 0));
		}

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (visited[edge.to])
				continue;

			visited[edge.to] = true;
			total += edge.weight;

			for (Edge next : edges[edge.to]) {
				if (!visited[next.to])
					queue.offer(next);
			}
		}

		System.out.println(total);

	}

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
}