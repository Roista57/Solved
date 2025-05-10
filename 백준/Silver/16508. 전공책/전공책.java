import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Book[] books;
	static boolean[] select;
	static int N;
	static int[] target;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = new int[26];
		String str = br.readLine();
		for (char a : str.toCharArray()) {
			target[a - 'A']++;
		}
		N = Integer.parseInt(br.readLine());

		books = new Book[N];
		select = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			books[i] = new Book(cost, name);
		}
		func(0);
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}

	static void func(int idx) {
		if (idx == N) {
			int cost = 0;
			int[] temp = new int[26];
			for (int i = 0; i < 26; i++) {
				temp[i] = target[i];
			}
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					cost += books[i].cost;
					for (int j = 0; j < books[i].name.length(); j++) {
						temp[books[i].name.charAt(j) - 'A']--;
					}
				}
			}
			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (temp[i] > 0) {
					flag = false;
				}
			}
			if (flag) {
				if (cost != 0) {
					min = Math.min(min, cost);
				}
			}
			return;
		}

		select[idx] = true;
		func(idx + 1);

		select[idx] = false;
		func(idx + 1);
	}

	static class Book {
		int cost;
		String name;

		public Book(int cost, String name) {
			this.cost = cost;
			this.name = name;
		}
	}
}