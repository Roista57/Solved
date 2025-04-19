import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int i = 1;

		int cnt = 0;
		int ans = 0;
		while (i < M - 1) {
			if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				cnt++;
				if (cnt == N) {
					ans++;
					cnt--;
				}
				i += 2;
			} else {
				i++;
				cnt = 0;
			}
		}
		System.out.println(ans);
	}
}