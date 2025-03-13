import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹을 수 있는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int max = Integer.MIN_VALUE;

		int size = N + k - 1;
		int[] list = new int[size];
		int[] select = new int[d + 1];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < size; i++) {
			list[i] = list[i - N];
		}

		int start = 0;
		int end = 0;

		int cnt = 0;
		int count = 0;
		while (end < size) {
			if (cnt < k) {
				if (select[list[end]] == 0) {
					count++;
				}
				select[list[end++]]++;
				cnt++;
			} else {
				if (select[list[start]] == 1) {
					count--;
				}
				select[list[start++]]--;
				cnt--;
			}

			if (end <= size && select[c] == 0) {
				max = Math.max(max, count + 1);
			} else {
				max = Math.max(max, count);
			}

		}
		System.out.println(max);

	}
}