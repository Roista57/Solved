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
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Queue<Integer> list = new ArrayDeque<Integer>();
		Queue<Integer> bridge = new ArrayDeque<Integer>();
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		int count = 0;
		while (!list.isEmpty() || sum != 0) {
			sum -= bridge.poll();
			if (!list.isEmpty() && sum + list.peek() <= L) {
				int truck = list.poll();
				bridge.add(truck);
				sum += truck;
			} else {
				bridge.add(0);
			}
			count++;
//			System.out.println(bridge.toString() + " : " + sum);
		}
		System.out.println(count);
	}
}