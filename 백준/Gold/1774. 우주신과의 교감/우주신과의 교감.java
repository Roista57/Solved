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

	static ArrayList<Node> list;
	static boolean[] visited;
	static ArrayList<Edge>[] edges;
	static double[][] map;
	static boolean[] run;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		run = new boolean[N + 1];
		visited = new boolean[N + 1];
		edges = new ArrayList[N + 1];
		map = new double[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nowi = Integer.parseInt(st.nextToken());
			int nowj = Integer.parseInt(st.nextToken());
			list.add(new Node(nowi, nowj));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int from = i;
				int to = j;
				double weight = Math.sqrt(Math.pow(list.get(from).i - list.get(to).i, 2)
						+ Math.pow(list.get(from).j - list.get(to).j, 2));
				edges[from + 1].add(new Edge(from + 1, to + 1, weight));
				edges[to + 1].add(new Edge(to + 1, from + 1, weight));

				map[from + 1][to + 1] = weight;
				map[to + 1][from + 1] = weight;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 0;
			map[to][from] = 0;
		}

//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < N + 1; j++) {
//				System.out.printf("%.02f ", map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		double total = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(0, 1, 0));

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (visited[edge.to])
				continue;

//			System.out.println(edge.to + " " + edge.weight);
			visited[edge.to] = true;
			total += edge.weight;

			for (int i = 1; i < N + 1; i++) {
				if (i == edge.to)
					continue;
				if (!visited[i]) {
					queue.offer(new Edge(edge.to, i, map[i][edge.to]));
					queue.offer(new Edge(i, edge.to, map[edge.to][i]));
				}
			}
		}
		System.out.printf("%.2f\n", total);
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}