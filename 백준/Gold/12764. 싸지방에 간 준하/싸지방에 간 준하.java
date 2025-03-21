import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] list = new int[N][2];
		int[] computer = new int[N + 1];
		Queue<Integer> computerNumQueue = new PriorityQueue<Integer>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			computerNumQueue.add(i + 1);
		}

		Arrays.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		Queue<Node> queue = new PriorityQueue<Node>();

		int latest = 0;
		int seat = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			latest = list[i][0];
			while (!queue.isEmpty()) {
				if (queue.peek().time[1] > latest) {
					break;
				}
				Node n = queue.poll();
				computerNumQueue.add(n.computerNumber);
			}
			seat = computerNumQueue.poll();
			queue.add(new Node(list[i], seat));
			computer[seat]++;
			max = Math.max(max, queue.size());
//			System.out.println("latest: " + latest + ", queue: " + queue.peek().time[1]);
		}

		System.out.println(max);
		for (int i = 1; i <= N; i++) {
			if (computer[i] == 0) {
				break;
			}
			System.out.print(computer[i] + " ");
		}

	}

	static class Node implements Comparable<Node> {
		int[] time;
		int computerNumber;

		public Node(int[] time, int computerNumber) {
			this.time = time;
			this.computerNumber = computerNumber;
		}

		public int compareTo(Node o) {
			return time[1] - o.time[1];
		}
	}
}