import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;

		int[][] dist = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], INF);
		}

		List<List<Node>> list = new ArrayList<List<Node>>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, weight));
			list.get(to).add(new Node(from, weight));
		}

		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int start = 1;

		for (int i = 1; i <= N; i++) {
			if(i != start && i != u && i != v && i != N) continue;
			Queue<Node> queue = new PriorityQueue<Node>();
			queue.add(new Node(i, 0));
			dist[i][i] = 0;

			while (!queue.isEmpty()) {
				Node node = queue.poll();

				if (node.weight > dist[i][node.to])
				continue;

				for (Node newNode : list.get(node.to)) {
					int newDist = newNode.weight + dist[i][node.to];
					if (newDist < dist[i][newNode.to]) {
						queue.add(new Node(newNode.to, newDist));
						dist[i][newNode.to] = newDist;
					}
				}
			}
		}

		//		for (int i = 1; i <= N; i++) {
			//			System.out.println(Arrays.toString(dist[i]));
			//		}
			//		System.out.println(dist[start][u] + ", " + dist[u][v] + ", " + dist[v][N]);
			//		System.out.println(dist[start][v] + ", " + dist[v][u] + ", " + dist[u][N]);

			int a = INF;
			int b = INF;
			if (dist[start][u] != INF && dist[u][v] != INF && dist[v][N] != INF) {
				a = dist[start][u] + dist[u][v] + dist[v][N];
			}
			if (dist[start][v] != INF && dist[v][u] != INF && dist[u][N] != INF) {
				b = dist[start][v] + dist[v][u] + dist[u][N];
			}
			if (a == INF && b == INF) {
				System.out.println(-1);
			} else {
				int min = Math.min(a, b);
				System.out.println(min);
			}
		}

		static class Node implements Comparable<Node> {
			int to, weight;

			public Node(int to, int weight) {
				this.to = to;
				this.weight = weight;
			}

			@Override
			public int compareTo(Node o) {
				return this.weight - o.weight;
			}
		}

	}