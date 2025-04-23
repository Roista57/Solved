import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return o2.compareTo(o1);
			}
		});

		st = new StringTokenizer(br.readLine());
		long total = 0;
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			total += num;
			queue.add(num);
			if (total >= M) {
				total -= queue.poll() * 2L;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}