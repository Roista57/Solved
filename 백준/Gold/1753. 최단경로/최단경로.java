import java.awt.Adjustable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static Node[] adj;
	static int V, E;
	static int startV;

	static int[] minDins;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		startV = Integer.parseInt(br.readLine());
		adj = new Node[V+1];
		minDins = new int[V + 1];
		visited = new boolean[V + 1];
		

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[from] = new Node(to, weight, adj[from]);
		}
		
		Arrays.fill(minDins, INF);
		
		dijkstra();

	}

	static void dijkstra() {
		minDins[startV] = 0; // 시작 정점
		int min = 0;
		int stopOver = 0;
		
		for(int i=1;i<=V;i++) {
			min = INF;
			stopOver = -1;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min > minDins[j]) {
					min = minDins[j];
					stopOver = j;
					
				}
			}
			
			if(stopOver == -1) break;
			visited[stopOver] = true;
			
			for(Node temp = adj[stopOver]; temp != null; temp = temp.next) {
				if(minDins[temp.to] > min + temp.weight) {
					minDins[temp.to] = min + temp.weight;
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(minDins[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(minDins[i]);
			}
		}
		
		

	}

	static class Node {
		int to;
		int weight;
		Node next;
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
}