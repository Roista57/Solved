import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] map;
	static boolean[] select;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			map = new int[N + 1];
			visited = new boolean[N + 1];

			select = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				if (!visited[i])
					func(i);
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (!select[i])
					cnt++;
			}
			System.out.println(cnt);
		}

	}

	static void func(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(start);
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (!visited[map[num]]) {
				queue.offer(map[num]);
				visited[map[num]] = true;
			}
			list.add(map[num]);
			if (map[num] == start || num == map[num]) { // 한 팀이 되었다.
				break;
			}
		}
//		System.out.println(list.toString());
		int end = list.get(list.size() - 1);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == end) {
				for (int j = i; j < list.size() - 1; j++) {
					select[list.get(j)] = true;
//					System.out.print(list.get(j) + " ");
				}
				break;
			}
		}
//		System.out.println();
	}
}