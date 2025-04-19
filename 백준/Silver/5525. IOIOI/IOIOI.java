import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String target = "I";
		for (int i = 0; i < N; i++) {
			target += "OI";
		}
		int size = target.length();

		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int cnt = 0;
		for (int i = 0; i <= M - size; i++) {
			if (S.substring(i, size + i).equals(target)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}