import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[N];
		Arrays.fill(cnt, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (list[i] > list[j]) {
					cnt[i] = Math.max(cnt[j] + 1, cnt[i]);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, cnt[i]);
		}
		System.out.println(ans);
	}

}