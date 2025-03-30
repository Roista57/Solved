import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] list;
	static boolean[] select;
	static int N;
	static long sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			list = new int[N];
			select = new boolean[N];
			sum = 0;
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}

			if (N == 0) {
				System.out.println(list[0]);
			} else {
				func(0, 0);
				System.out.println(sum);
			}
		}
	}

	static void func(int idx, int cnt) {
		if (cnt == 2) {
			int[] num = new int[2];
			int temp = 0;
			int c = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					num[c++] = list[i];
				}
			}
			if (num[0] < num[1]) {
				temp = num[0];
				num[0] = num[1];
				num[1] = temp;
			}
			int result = 0;
			while (true) {
				result = gcd(num[0], num[1]);
				if (result == 0)
					break;
				num[0] = num[1];
				num[1] = result;
			}
			sum += num[1];
			return;
		}
		if (idx == N)
			return;
		select[idx] = true;
		func(idx + 1, cnt + 1);
		select[idx] = false;
		func(idx + 1, cnt);
	}

	static int gcd(int a, int b) {
		return a % b;
	}
}