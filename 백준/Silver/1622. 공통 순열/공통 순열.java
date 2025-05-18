import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a, b;
		while ((a = br.readLine()) != null && (b = br.readLine()) != null) {
			int[] countA = new int[26];
			int[] countB = new int[26];

			for (int i = 0; i < a.length(); i++) {
				countA[a.charAt(i) - 'a']++;
			}

			for (int i = 0; i < b.length(); i++) {
				countB[b.charAt(i) - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				int min = Math.min(countA[i], countB[i]);
				for (int j = 0; j < min; j++) {
					sb.append((char) ('a' + i));
				}
			}
			System.out.println(sb.toString());
		}
	}
}