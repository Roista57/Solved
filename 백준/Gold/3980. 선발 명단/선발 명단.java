import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int N = 11;
	static boolean[] select;
	static int[][] list;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			list = new int[N][N];
			select = new boolean[N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			func(0, 0);
			System.out.println(max);
		}
	}

	static void func(int idx, int sum) {
		if (idx == N) {
			max = Math.max(max, sum);
			return;
		}
		for (int j = 0; j < N; j++) {
			if (list[idx][j] != 0 && !select[j]) {
				select[j] = true;
				func(idx + 1, sum + list[idx][j]);
				select[j] = false;
			}
		}
	}
}