import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] select = new boolean[N + 1];

		ArrayList<Integer>[] citys = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			citys[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			citys[a].add(b);
			citys[b].add(a);
		}

		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int city = Integer.parseInt(st.nextToken());
			select[city] = true;
		}

		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				boolean flag = true;
				for (int a : citys[i]) {
					if (!select[a]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					list.add(i);
				}
			}
		}
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			visited[num] = true;
			for (int a : citys[num]) {
				visited[a] = true;
			}
		}
		boolean flag = true;
		for (int i = 0; i <= N; i++) {
			if (visited[i] != select[i]) {
				flag = false;
				break;
			}
		}

		if (flag) {
			sb.append(list.size() + "\n");
			for (int a : list) {
				sb.append(a + " ");
			}
			System.out.println(sb.toString());
		} else {
			System.out.println("-1");
		}

	}

}