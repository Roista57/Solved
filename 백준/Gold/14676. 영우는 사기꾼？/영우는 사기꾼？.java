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
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		ArrayList<Integer>[] connect = new ArrayList[N + 1];
		int[] build = new int[N + 1];
		boolean[] buildFlag = new boolean[N + 1]; // 건설이 가능한지

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
			connect[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[b].add(a);
			connect[a].add(b);
		}

		boolean lier = false;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int building = Integer.parseInt(st.nextToken());

			boolean possible = true;
			if (type == 1) { // 건설
				if (!buildFlag[building]) { // 이전에 확인한 적이 없는 경우
					for (int j = 0; j < list[building].size(); j++) {
						if (!possible) {
							break;
						}
						if (build[list[building].get(j)] == 0) { // 필요한 건물이 없는 경우
							possible = false;
						}
					}

					if (!possible) {
						lier = true;
					} else {
						// 선행 건물들이 모두 있다.
						buildFlag[building] = true;
					}
				}
				build[building]++;
			} else { // 파괴
				if (build[building] == 0) {
					lier = true;
				} else {
					build[building]--;
					if (build[building] == 0) { // 해당 건물을 모두 철거함
						for (int j = 0; j < connect[building].size(); j++) {
							buildFlag[connect[building].get(j)] = false;
						}
					}
				}
			}
		}

		if (!lier) {
			System.out.println("King-God-Emperor");
		} else {
			System.out.println("Lier!");
		}

	}

}