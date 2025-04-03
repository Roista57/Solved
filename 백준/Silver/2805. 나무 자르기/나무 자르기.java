import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이

		int[] list = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		long sum = 0;
		int start = 0;
		int end = list[N - 1];
		int ans = 0;

		int mid = (start + end) / 2;

		while (start <= end) {
			sum = 0;
			int num = Arrays.binarySearch(list, mid);
			if (num < 0)
				num = -(num + 1);
			for (int i = num; i < N; i++) {
				sum += Math.max(0, list[i] - mid);
			}
			if (sum >= M) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		System.out.println(ans);
	}
}