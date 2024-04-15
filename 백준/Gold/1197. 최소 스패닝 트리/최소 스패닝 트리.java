import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V; // 정점 수
	static int E; // 간선 수
	static List<Edge>[] list;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		visited = new boolean[V + 1];
		list = new List[V + 1];

		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}

		System.out.println(prim());
	}

	static int prim() {
		int total = 0; // mst 비용
		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(1, 0));

		while (!queue.isEmpty()) {
			Edge e = queue.poll();

			if (visited[e.to])
				continue;

			visited[e.to] = true;
			total += e.weight;

			for (Edge next : list[e.to]) {
				if (!visited[next.to]) {
					queue.offer(next);
				}
			}
		}
		return total;
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}