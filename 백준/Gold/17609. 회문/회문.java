import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String line = br.readLine();

			int start = 0;
			int end = line.length() - 1;
			System.out.println(func(line, start, end, 1));
		}

	}

	static int func(String line, int start, int end, int cnt) {
		int type = 0;
		while (start <= end) {
//			System.out.println(cnt + ") " + line.charAt(start) + " : " + line.charAt(end));
			if (line.charAt(start) == line.charAt(end)) {
				start++;
				end--;
				continue;
			} else {
				if (cnt == 1) {
					cnt--;
					type = func(line, start + 1, end, 0);
					type = func(line, start, end - 1, 0) == 1 ? 1 : type;
				} else {
					type = 2;
				}
				break;
			}
		}
		if (type != 2) {
			if (cnt == 0) {
				type = 1;
			}
		}
		return type;
	}

}