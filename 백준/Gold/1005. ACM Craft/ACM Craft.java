import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[][] map;
	static int[] cost;
	static int[] temp;
	static int[] len;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + 1][N + 1];
			cost = new int[N + 1];
			temp = new int[N + 1];
			len = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
				temp[i] = cost[i];
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
				len[to]++;
			}
			int target = Integer.parseInt(br.readLine());

			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i < N + 1; i++) {
				if (len[i] == 0) {
					queue.offer(i);
				}
			}

			while (!queue.isEmpty()) {
				int num = queue.poll();

				if (num == target) {
					System.out.println(temp[num]);
					break;
				}

				for (int i = 1; i < N + 1; i++) {
					if (map[num][i] == 1) {
						temp[i] = Math.max(temp[i], temp[num] + cost[i]);
						if (--len[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}
		}
	}
}