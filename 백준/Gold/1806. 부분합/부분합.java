import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int S;
	static int[] dp;
	static int[] list;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		list = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int total = 0;
		int start = 0;
		int end = 0;

		while (end <= N) {
			if (total >= S) {
				min = Math.min(min, end - start);
				total -= list[start++];
			} else if (end == N) {
				break;
			} else {
				total += list[end++];
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println("0");
		} else {
			System.out.println(min);
		}
	}
}