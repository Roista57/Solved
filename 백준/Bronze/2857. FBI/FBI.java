import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 1; i <= 5; i++) {
			String str = br.readLine();
			if (str.contains("FBI")) {
				sb.append(i + " ");
				flag = true;
			}
		}
		if (flag) {
			System.out.println(sb.toString());
		} else {
			System.out.println("HE GOT AWAY!");
		}

	}

}