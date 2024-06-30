import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;

	static int[] map;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visited = new boolean[F + 1];
		bfs();
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(S);
		visited[S] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (--size >= 0) {
				int num = queue.poll();

				if (num == G) {
					System.out.println(cnt);
					flag = true;
					return;
				}
				if (num + U <= F && !visited[num + U]) {
					visited[num + U] = true;
					queue.offer(num + U);
				}
				if (num - D > 0 && !visited[num - D]) {
					visited[num - D] = true;
					queue.offer(num - D);
				}
			}
			if (flag)
				break;
			cnt++;
		}
		if (!flag) {
			System.out.println("use the stairs");
		}
	}
}