import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st;
			HashMap<Integer, Integer> map = new HashMap<>();
			Queue<Integer> queue1 = new PriorityQueue<>();
			Queue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				if (ch == 'I') {
					int input = Integer.parseInt(st.nextToken());
					map.put(input, map.getOrDefault(input, 0) + 1);
					queue1.add(input);
					queue2.add(input);
				} else {
					int delete = Integer.parseInt(st.nextToken());
					if (delete == 1) { // 최대값 삭제
						if (!queue2.isEmpty()) {
							while (!queue2.isEmpty()) {
								int num = queue2.poll();
								if (map.containsKey(num)) {
									if (map.get(num) == 1) {
										map.remove(num);
									} else {
										map.put(num, map.get(num) - 1);
									}
									break;
								}
							}
						}
					} else { // 최솟값 삭제
						if (!queue1.isEmpty()) {
							while (!queue1.isEmpty()) {
								int num = queue1.poll();
								if (map.containsKey(num)) {
									if (map.get(num) == 1) {
										map.remove(num);
									} else {
										map.put(num, map.get(num) - 1);
									}
									break;
								}
							}
						}
					}
				}
			}
			while (!queue1.isEmpty()) {
				if (map.containsKey(queue1.peek())) {
					break;
				}
				queue1.poll();
			}
			while (!queue2.isEmpty()) {
				if (map.containsKey(queue2.peek())) {
					break;
				}
				queue2.poll();
			}
			if (!queue1.isEmpty() && !queue2.isEmpty()) {
				sb.append(queue2.peek() + " " + queue1.peek() + "\n");
			} else {
				sb.append("EMPTY" + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}