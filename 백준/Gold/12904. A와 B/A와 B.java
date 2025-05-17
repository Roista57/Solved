import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

		StringBuilder sb = new StringBuilder(T);

		int N = sb.length();
		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			char ch = sb.charAt(i);
			sb.deleteCharAt(i);
			if (ch == 'B') {
				sb.reverse();
			}
			//			System.out.println(sb.toString());
			if (S.length() == sb.length()) {
				if (S.equals(sb.toString())) {
					ans = 1;
				}
				break;
			}
		}
		System.out.println(ans);
	}
}