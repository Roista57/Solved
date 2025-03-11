import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] numbers;
	static char[] operator;
	static boolean[] select;
	static int min;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operator = new char[N - 1];
		select = new boolean[N - 1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (i == 0) {
				for (int j = 0; j < num; j++) {
					operator[cnt++] = '+';
				}
			} else if (i == 1) {
				for (int j = 0; j < num; j++) {
					operator[cnt++] = '-';
				}
			} else if (i == 2) {
				for (int j = 0; j < num; j++) {
					operator[cnt++] = 'x';
				}
			} else if (i == 3) {
				for (int j = 0; j < num; j++) {
					operator[cnt++] = '/';
				}
			}
		}
		func(0, numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void func(int idx, int num) {
		if (idx == N - 1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (!select[i]) {
				select[i] = true;
				if (operator[i] == '+') {
					func(idx + 1, num + numbers[idx + 1]);
				} else if (operator[i] == '-') {
					func(idx + 1, num - numbers[idx + 1]);
				} else if (operator[i] == 'x') {
					func(idx + 1, num * numbers[idx + 1]);
				} else {
					func(idx + 1, num / numbers[idx + 1]);
				}
				select[i] = false;
			}
		}
	}
}