import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] list;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new int[N];
		temp = new int[20002];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			temp[list[i] + 10000]++;
		}

		Arrays.sort(list);
		long cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int sum = -(list[i] + list[j]);
				temp[list[i] + 10000]--;
				temp[list[j] + 10000]--;
				if (Math.abs(sum) <= 10000 && temp[sum + 10000] != 0) {
//					System.out.println(i + "," + j + ": " + list[i] + ", " + list[j] + ", " + sum);
//					System.out.println(temp[sum + 10000]);
					cnt += temp[sum + 10000];
				}
				temp[list[i] + 10000]++;
				temp[list[j] + 10000]++;
			}
		}
		System.out.println(cnt / 3);
//		System.out.println(Arrays.toString(list));

	}
}