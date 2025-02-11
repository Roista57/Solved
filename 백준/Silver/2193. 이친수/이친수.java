import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] list = new long[N + 1];
		list[1] = 1;
		for (int i = 2; i <= N; i++) {
			list[i] = list[i - 1] + list[i - 2];
		}
		System.out.println(list[N]);

	}

}