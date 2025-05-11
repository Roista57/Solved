import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			for (int d = 0; d < k; d++) {
				sb.append("=");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}