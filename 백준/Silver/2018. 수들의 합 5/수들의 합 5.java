import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		int s = 1;
		int e = 1;
		int cnt = 0;
		while (s <= N) {
			if (sum < N) {
				sum += e++;
			} else if (sum == N) {
				cnt++;
				sum -= s++;
			} else {
				sum -= s++;
			}
		}
		System.out.println(cnt);
	}
}