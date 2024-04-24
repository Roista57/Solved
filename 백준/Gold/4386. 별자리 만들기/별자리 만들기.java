import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Node[] stars;
	static boolean[] visited;
	static ArrayList<Edge>[] edges;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		stars = new Node[N];
		visited = new boolean[N];
		edges = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Node(x, y);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					double weight = Math
							.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
					edges[i].add(new Edge(j, weight));
					edges[j].add(new Edge(i, weight));
				}
			}
		}

		Queue<Edge> queue = new PriorityQueue<>();
		for (int i = 0; i < edges[0].size(); i++) {
			queue.offer(edges[0].get(i));
		}
		visited[0] = true;

		double total = 0;

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
		System.out.printf("%.2f", total);

	}

	static class Node {
		double x;
		double y;

		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		double weight;

		public Edge(int to, double weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(weight, o.weight);
		}
	}
}