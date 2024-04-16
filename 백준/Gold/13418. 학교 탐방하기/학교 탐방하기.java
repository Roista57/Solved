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
	static int M;

	static ArrayList<Edge>[] edges;
	static ArrayList<Edge>[] edges2;
	static int[] maxEdges;
	static int[] maxEdges2;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new ArrayList[N + 1];
		edges2 = new ArrayList[N + 1];
		maxEdges = new int[N + 1];
		maxEdges2 = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
			edges2[i] = new ArrayList<>();
		}

		for (int i = 0; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (weight == 0)
				weight = 1;
			else
				weight = 0;

			edges[from].add(new Edge(to, weight));
			edges[to].add(new Edge(from, weight));

			if (weight == 0)
				weight = 1;
			else
				weight = 0;

			edges2[from].add(new Edge(to, weight));
			edges2[to].add(new Edge(from, weight));
		}

		int total = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(edges[0].get(0));
		visited[0] = true;

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (visited[edge.to])
				continue;
			maxEdges[edge.to] = edge.weight;
			visited[edge.to] = true;
			for (Edge next : edges[edge.to]) {
				if (!visited[next.to])
					queue.offer(next);
			}
		}

		visited = new boolean[N + 1];

		int cnt = 0;
		queue.offer(edges2[0].get(0));
		visited[0] = true;

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (visited[edge.to])
				continue;
			maxEdges2[edge.to] = edge.weight;
			visited[edge.to] = true;
			for (Edge next : edges2[edge.to]) {
				if (!visited[next.to])
					queue.offer(next);
			}
		}

//		System.out.println(Arrays.toString(maxEdges));
		int cnt1 = 0;
		for (int i = 1; i < N + 1; i++) {
			if (maxEdges[i] == 1)
				cnt1++;
		}

		int cnt2 = 0;
		for (int i = 1; i < N + 1; i++) {
			if (maxEdges2[i] == 0)
				cnt2++;
		}
//		System.out.println(Arrays.toString(maxEdges2));
		System.out.println((int) Math.pow(cnt2, 2) - (int) Math.pow(cnt1, 2));
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

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
	}
}