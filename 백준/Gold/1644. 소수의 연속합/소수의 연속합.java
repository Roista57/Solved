import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static int[] list;
	static ArrayList<Integer> nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new int[N + 1];
		nums = new ArrayList<>();

		for (int i = 2; i < N + 1; i++) {
			if (list[i] == 0) {
				nums.add(i);
				for (int j = i; j < N + 1; j += i) {
					list[j] = 1;
				}
			}
		}

		int start = 0;
		int end = 0;
		int total = 0;

		int cnt = 0;
		while (true) {
//			System.out.println(start+", "+end);
			if (total >= N) {
				if (total == N) {
					cnt++;
				}
				if (start < nums.size())
					total -= nums.get(start++);
			} else {
				if (end < nums.size()) {
					total += nums.get(end++);
				} else {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}