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
	static ArrayList<Edge>[] edges;
	static Node[] xSite;
	static Node[] ySite;
	static Node[] zSite;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		edges = new ArrayList[N];
		xSite = new Node[N];
		ySite = new Node[N];
		zSite = new Node[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			xSite[i] = new Node(i, x);
			ySite[i] = new Node(i, y);
			zSite[i] = new Node(i, z);
		}

		Arrays.sort(xSite);
		Arrays.sort(ySite);
		Arrays.sort(zSite);

		for (int i = 0; i < N; i++) {
			long up = Integer.MAX_VALUE;
			long down = Integer.MAX_VALUE;
			if (i - 1 >= 0) {
				down = Math.abs(xSite[i - 1].site - xSite[i].site);
				edges[xSite[i].num].add(new Edge(xSite[i - 1].num, down));
				edges[xSite[i - 1].num].add(new Edge(xSite[i].num, down));

			}
			if (i + 1 < N) {
				up = Math.abs(xSite[i].site - xSite[i + 1].site);
				edges[xSite[i].num].add(new Edge(xSite[i + 1].num, up));
				edges[xSite[i + 1].num].add(new Edge(xSite[i].num, up));
			}
		}
		for (int i = 0; i < N; i++) {
			long up = Integer.MAX_VALUE;
			long down = Integer.MAX_VALUE;
			if (i - 1 >= 0) {
				down = Math.abs(ySite[i - 1].site - ySite[i].site);
				edges[ySite[i].num].add(new Edge(ySite[i - 1].num, down));
				edges[ySite[i - 1].num].add(new Edge(ySite[i].num, down));
			}
			if (i + 1 < N) {
				up = Math.abs(ySite[i].site - ySite[i + 1].site);
				edges[ySite[i].num].add(new Edge(ySite[i + 1].num, up));
				edges[ySite[i + 1].num].add(new Edge(ySite[i].num, up));
			}
		}
		for (int i = 0; i < N; i++) {
			long up = Integer.MAX_VALUE;
			long down = Integer.MAX_VALUE;
			if (i - 1 >= 0) {
				down = Math.abs(zSite[i - 1].site - zSite[i].site);
				edges[zSite[i].num].add(new Edge(zSite[i - 1].num, down));
				edges[zSite[i - 1].num].add(new Edge(zSite[i].num, down));
			}
			if (i + 1 < N) {
				up = Math.abs(zSite[i].site - zSite[i + 1].site);
				edges[zSite[i].num].add(new Edge(zSite[i + 1].num, up));
				edges[zSite[i + 1].num].add(new Edge(zSite[i].num, up));
			}
		}

		long total = 0;
		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(0, 0));

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

	static class Node implements Comparable<Node> {
		int num;
		long site;

		public Node(int num, long site) {
			this.num = num;
			this.site = site;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(site, o.site);
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(weight, o.weight);
		}
	}
}