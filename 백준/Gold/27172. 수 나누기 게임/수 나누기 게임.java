import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] select;
	static int[][] map;
	static int[] list;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new int[N];
		select = new boolean[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = 0;
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			select[list[i]] = true;
			max = Integer.max(max, list[i]);
		}
		map = new int[max + 1][2]; // 0 win, 1 loss
		for (int i = 0; i < N; i++) {
			for (int j = list[i]; j <= max; j += list[i]) {
				if (list[i] != j && select[j]) {
					map[list[i]][0]++;
					map[j][1]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print((map[list[i]][0] - map[list[i]][1]) + " ");
		}
	}
}