import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] decimal;
	static Queue<Decimal> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		decimal = new boolean[10000];
		for (int i = 2; i < decimal.length; i++) {
			int cnt = 0;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					cnt++;
				}
			}
			if (cnt == 1) {
				decimal[i] = true;
			}
		}

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			func(start, target);
		}

	}

	static void func(int start, int target) {
		queue = new ArrayDeque<>();
		boolean flag = false;
		boolean[] visited = new boolean[10000];
		queue.add(new Decimal(start, 0));
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (--size >= 0) {
				Decimal d = queue.poll();
				if (d.num == target) {
					System.out.println(d.count);
					flag = true;
					break;
				}

				char[] number = String.valueOf(d.num).toCharArray();

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j <= 9; j++) {
						if (number[i] - '0' != j) {
							char temp = number[i];
							number[i] = (char) (j + '0');
							int num = Integer.parseInt(new String(number));
							if (!visited[num] && num >= 1000 && decimal[num]) {
								queue.add(new Decimal(num, d.count + 1));
								visited[num] = true;
							}
							number[i] = temp;
						}
					}
				}
			}
			if (flag)
				break;
		}
		if (!flag) {
			System.out.println("Impossible");
		}
	}

	static class Decimal {
		int num;
		int count;

		public Decimal(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
}