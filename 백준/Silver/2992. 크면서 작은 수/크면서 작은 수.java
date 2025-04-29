import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static String number;
	static int integerNumber;
	static boolean[] select;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = sc.next();
		integerNumber = Integer.parseInt(number);
		N = number.length();
		select = new boolean[N];
		queue = new PriorityQueue<>();
		func(0, "");
		if (queue.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(queue.poll());
		}
	}

	static void func(int idx, String str) {
		if (idx == N) {
			int num = Integer.parseInt(str);
			if (integerNumber < num) {
				queue.add(num);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!select[i]) {
				select[i] = true;
				func(idx + 1, str + number.charAt(i));
				select[i] = false;
			}
		}
	}

}