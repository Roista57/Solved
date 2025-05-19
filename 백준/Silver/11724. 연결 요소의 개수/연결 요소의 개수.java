import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N + 1];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt++;
				Queue<Integer> queue = new ArrayDeque<>();
				queue.add(i);
				visited[i] = true;

				while (!queue.isEmpty()) {
					int node = queue.poll();

					for (int d = 0; d < list.get(node).size(); d++) {
						int num = list.get(node).get(d);
						if (!visited[num]) {
							queue.add(num);
							visited[num] = true;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}