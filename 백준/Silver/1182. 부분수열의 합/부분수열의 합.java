import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int S;
	static int[] list;
	static boolean[] select;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		list = new int[N];
		select = new boolean[N];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		func(0);
		System.out.println(cnt);
	}

	static void func(int idx) {
		if (idx == N) {
			int sum = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					flag = true;
					sum += list[i];
				}

			}

			if (flag && sum == S) {
				cnt++;
			}
			return;
		}

		select[idx] = true;
		func(idx + 1);
		select[idx] = false;
		func(idx + 1);
	}

}