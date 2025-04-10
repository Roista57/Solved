import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Integer> list1 = new ArrayDeque<>();
		Queue<Integer> list2 = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list1.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}

		while (true) {
			if (list1.isEmpty() && list2.isEmpty()) {
				System.out.println(sb.toString());
				break;
			} else if (!list1.isEmpty() && list2.isEmpty()) {
				sb.append(list1.poll() + " ");
			} else if (list1.isEmpty() && !list2.isEmpty()) {
				sb.append(list2.poll() + " ");
			} else {
				if (list1.peek() <= list2.peek()) {
					sb.append(list1.poll() + " ");
				} else {
					sb.append(list2.poll() + " ");
				}
			}
		}
	}
}