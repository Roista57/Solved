import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());

			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());

			int time1 = h1 * 60 * 60 + m1 * 60 + s1;
			int time2 = h2 * 60 * 60 + m2 * 60 + s2;
			int ans = time2 - time1;
			System.out.println(ans / 60 / 60 + " " + ans % 3600 / 60 + " " + ans % 60);
		}
	}

}