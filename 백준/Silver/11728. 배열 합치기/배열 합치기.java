import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] list = new int[N + M];
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[cnt++] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list[cnt++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		for (int i = 0; i < list.length; i++) {
			sb.append(list[i] + " ");
		}
		System.out.println(sb.toString());

	}
}