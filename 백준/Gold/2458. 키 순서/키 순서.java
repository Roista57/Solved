import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] people = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			people[a][b] = 1;
		}

		int cnt = 0;
		for (int i = 1; i < people.length; i++) {
			boolean[] idx = new boolean[n + 1];
			int count = 0;

			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(i);

			while (!queue.isEmpty()) {
				int next = queue.poll();

				for (int j = 0; j < n + 1; j++) {
					if (people[next][j] == 1 && !idx[j]) {
						queue.offer(j);
						idx[j] = true;
					}
				}
			}

			queue.offer(i);
			while (!queue.isEmpty()) {
				int next = queue.poll();

				for (int j = 0; j < n + 1; j++) {
					if (people[j][next] == 1 && !idx[j]) {
						queue.offer(j);
						idx[j] = true;
					}
				}
			}

			for (boolean visit : idx) {
				if (visit)
					count++;
			}

			if (count == n - 1)
				cnt++;
		}
		System.out.println(cnt);
	}
}