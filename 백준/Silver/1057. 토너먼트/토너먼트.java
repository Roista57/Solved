import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int A;
	static int B;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int cnt = 1;
		boolean flag = true;
		while (flag) {
			int size = queue.size();
			if (size == 1) {
				System.out.println(-1);
				break;
			}
			if (size % 2 == 1) {
				queue.add(0);
				size++;
			}
			for (int i = 0; i < size / 2; i++) {
				int a = queue.poll();
				int b = queue.poll();

				if (a == A) {
					if (b == B) {
						System.out.println(cnt);
						flag = false;
					} else {
//						System.out.print(a + " ");
						queue.add(a);
					}
				} else if (a == B) {
					if (b == A) {
						System.out.println(cnt);
						flag = false;
					} else {
//						System.out.print(a + " ");
						queue.add(a);
					}
				} else {
					if (b == A || b == B) {
//						System.out.print(b + " ");
						queue.add(b);
					} else {
//						System.out.print(a + " ");
						queue.add(a);
					}
				}
			}
//			System.out.println();
			cnt++;
		}
	}
}