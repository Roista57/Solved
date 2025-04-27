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

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int X = Integer.parseInt(br.readLine());

		Arrays.sort(list);

		int start = 0;
		int end = N - 1;
		int cnt = 0;
		while (start < end) {
			if (list[start] + list[end] == X) {
//				System.out.println(list[start] + ", " + list[end]);
				cnt++;
				start++;
				end--;
			} else if (list[start] + list[end] > X) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(cnt);
	}

}