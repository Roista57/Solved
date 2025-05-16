import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		int start = 0;
		int end = N - 1;
		int cnt = 0;
		while (start < end) {
			if (list[start] + list[end] == M) {
				cnt++;
				start++;
				end--;
			} else if (list[start] + list[end] < M) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(cnt);
	}
}