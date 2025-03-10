import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static StringBuilder sb;
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		list = new int[M];
		func(0, 0);
		System.out.println(sb.toString());

	}

	static void func(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(list[i] + " ");
			}
			sb.append("\n");
			return;
		}
		if (idx <= N) {
			for (int i = 1; i <= N; i++) {
				list[idx] = i;
				func(idx + 1, cnt + 1);
			}
		}

	}

}