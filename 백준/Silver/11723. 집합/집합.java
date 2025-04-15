import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int S = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			if (type.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				S |= (1 << x);
			} else if (type.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				S &= ~(1 << x);
			} else if (type.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if ((S & (1 << x)) == 0) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}
			} else if (type.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				S ^= (1 << x);
			} else if (type.equals("all")) {
				S = 2097150;
			} else if (type.equals("empty")) {
				S = 0;
			}
		}
		System.out.println(sb.toString());
	}
}