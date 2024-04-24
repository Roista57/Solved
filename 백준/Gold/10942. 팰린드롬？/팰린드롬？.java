import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		list = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			if (S == E)
				sb.append("1\n");
			else {
				boolean flag = true;
				while (S <= E) {
					if (list[S] == list[E]) {
						S++;
						E--;
					} else {
						flag = false;
						break;
					}
				}
				if (flag)
					sb.append("1\n");
				else
					sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
}