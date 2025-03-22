import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] list = new long[33334];
		list[2] = 2;
		for (int i = 3; i <= 33333; i++) {
			list[i] = (list[i-1] * 3) % 1000000009;
		}
		System.out.println(list[N]);
	}
}