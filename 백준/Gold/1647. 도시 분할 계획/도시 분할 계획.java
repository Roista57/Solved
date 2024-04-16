import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 집의 개수
	static int M; // 도로의 개수
	static Edge[] roads; // A to B, weight
	static ArrayList<Edge>[] list; // 인접 리스트
	static boolean[] visited; // 집을 방문 했는지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		roads = new Edge[M];
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}

		int total = 0;
		int max = Integer.MIN_VALUE;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(1, 0));

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();

			if (visited[edge.to])
				continue;

			visited[edge.to] = true;
			max = Integer.max(max, edge.weight);
			total += edge.weight;

			for (Edge next : list[edge.to]) {
				if (!visited[next.to])
					queue.offer(next);
			}
		}

		System.out.println(total - max);

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
			return Integer.compare(weight, o.weight);
		}

	}
}