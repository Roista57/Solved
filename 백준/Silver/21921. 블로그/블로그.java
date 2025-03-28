import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] days = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int max = 0;
		int start = 0;
		int end = 0;
		int total = 0;

		while (end < N) {
			if (end - start < X) {
				total += days[end++];
			} else {
				total -= days[start++];
			}
			if ((end - start) == X) {
				if (max < total) {
					max = total;
					cnt = 1;
				} else if (max == total) {
					cnt++;
				}
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}

}