import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int MAX = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			MAX = Math.max(MAX, list[i]);
		}

		int left = 0;
		int right = 0;
		long cnt = 0;
		int[] select = new int[MAX + 1];

		long total = 0;
		while (left < N && right < N) {
			if (select[list[right]] != 0 && left != right) {
				long addNum = (cnt * (cnt + 1)) / 2;
				long subNum = ((cnt - 1) * ((cnt - 1) + 1)) / 2;
				total += addNum - subNum;
				cnt--;
				select[list[left++]]--;
			} else {
				select[list[right++]]++;
				cnt++;
			}
		}
		long addNum = (cnt * (cnt + 1)) / 2;
		total += addNum;
		System.out.println(total);
	}
}