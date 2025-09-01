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
		int N = Integer.parseInt(st.nextToken()); // 마을 개수
		int M = Integer.parseInt(st.nextToken()); // 도로 개수
		int X = Integer.parseInt(st.nextToken()); // 도착 지점

		int[][] dist = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		List<List<Node>> list = new ArrayList<List<Node>>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, time));
		}
		for (int i = 1; i <= N; i++) {
			Queue<Node> queue = new PriorityQueue<Node>();
			queue.add(new Node(i, 0));
			dist[i][i] = 0;

			while (!queue.isEmpty()) {
				Node node = queue.poll();

				if (node.time > dist[i][node.to])
				continue;

				for (Node newNode : list.get(node.to)) {
					int newDist = newNode.time + dist[i][node.to];
					if (newDist < dist[i][newNode.to]) {
						queue.add(new Node(newNode.to, newDist));
						dist[i][newNode.to] = newDist;
					}
				}
			}
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, dist[i][X]+dist[X][i]);
			//			System.out.println("S: "+dist[i][X]+", E: "+dist[X][i]+", time: "+(dist[i][X]+dist[X][i]));
		}
		System.out.println(max);




	}

	static class Node implements Comparable<Node> {
		int to, time;

		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}