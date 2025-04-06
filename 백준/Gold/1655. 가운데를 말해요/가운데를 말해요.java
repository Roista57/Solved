import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> leftQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		Queue<Integer> rightQueue = new PriorityQueue<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			if (leftQueue.size() == rightQueue.size()) {
				leftQueue.add(Integer.parseInt(br.readLine()));
			} else {
				rightQueue.add(Integer.parseInt(br.readLine()));
			}
			if (!rightQueue.isEmpty()) {
				while (leftQueue.peek() > rightQueue.peek()) {
					int temp = leftQueue.poll();
					leftQueue.add(rightQueue.poll());
					rightQueue.add(temp);
				}
			}
//			System.out.println(leftQueue.peek() + " " + (rightQueue.isEmpty() ? "Empty" : rightQueue.peek()));
			sb.append(leftQueue.peek() + "\n");
		}
		System.out.println(sb.toString());
	}
}