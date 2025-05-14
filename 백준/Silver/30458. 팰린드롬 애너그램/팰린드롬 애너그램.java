import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int[] list = new int[26];
		boolean flag = true;
		if (N % 2 == 0) {
			for (int i = 0; i < N; i++) {
				list[str.charAt(i) - 'a']++;
			}
		} else {
			for (int i = 0; i < N; i++) {
				if (i != (N / 2)) {
					list[str.charAt(i) - 'a']++;
				}
			}
		}

		for (int i = 0; i < 26; i++) {
			if (list[i] != 0) {
				if (list[i] % 2 == 1) {
					flag = false;
					break;
				}
			}
		}

		System.out.println(flag ? "Yes" : "No");
	}
}