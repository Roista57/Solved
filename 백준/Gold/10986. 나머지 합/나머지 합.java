import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] list = new long[N + 1];
		long[] mod = new long[M];
		long cnt = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			long num = Integer.parseInt(st.nextToken());
			list[i] = list[i - 1] + num;
		}

		for (int i = 0; i <= N; i++) {
			mod[(int) (list[i] % M)]++;
		}
		for (int i = 0; i < M; i++) {
			cnt += (mod[i] * (mod[i] - 1)) / 2;
		}
		System.out.println(cnt);
	}
}