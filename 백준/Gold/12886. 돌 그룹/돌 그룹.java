import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean flag = false;

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Stone stone = new Stone(A, B, C);
		Arrays.sort(stone.number);
		if (stone.number[0] == stone.number[1] && stone.number[0] == stone.number[2]) {
			flag = true;
		}
		HashMap<Stone, Integer> map = new HashMap<Stone, Integer>();
		map.put(stone, 1);

		Queue<Stone> queue = new ArrayDeque<Stone>();
		queue.add(stone);
		while (!queue.isEmpty() && !flag) {
			Stone s = queue.poll();

			int a = s.number[0];
			int b = s.number[1];
			int c = s.number[2];

			for (int i = 0; i < 3; i++) {
				Stone newStone;
				if (i == 0)
					newStone = new Stone(a + a, b - a, c);
				else if (i == 1)
					newStone = new Stone(a + a, b, c - a);
				else
					newStone = new Stone(a, b + b, c - b);
				Arrays.sort(newStone.number);
				if (newStone.number[0] == newStone.number[1] && newStone.number[0] == newStone.number[2]) {
					flag = true;
				}
				if (newStone.number[0] > 0 && !map.containsKey(newStone)) {
					map.put(newStone, 1);
					queue.add(newStone);
				}
			}
		}
		System.out.println(flag ? 1 : 0);

	}

	static class Stone {
		int[] number;

		public Stone(int a, int b, int c) {
			this.number = new int[] { a, b, c };
		}

		@Override
		public boolean equals(Object obj) {
			Stone o = (Stone) obj;
			if (number[0] == o.number[0] && number[1] == o.number[1] && number[2] == o.number[2]) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(number);
		}
	}
}