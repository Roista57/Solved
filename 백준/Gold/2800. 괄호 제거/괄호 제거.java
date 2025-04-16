import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Main {
	static ArrayList<Parentheses> list;
	static boolean[] select;
	static int N;
	static String str;
	static HashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		ans = new HashSet<>();
		list = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add(i);
			} else if (str.charAt(i) == ')') {
				list.add(new Parentheses(stack.pop(), i));
			}
		}
		N = list.size();
		select = new boolean[N];
		func(0, 0);

		String[] array = ans.toArray(new String[0]);
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i] + "\n");
		}
		System.out.println(sb.toString());
	}

	static void func(int idx, int cnt) {
		if (idx == N) {
			if (cnt == 0)
				return;
			StringBuilder sb = new StringBuilder();
			boolean[] strSelect = new boolean[str.length()];
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					strSelect[list.get(i).start] = true;
					strSelect[list.get(i).end] = true;
				}
			}
			for (int i = 0; i < str.length(); i++) {
				if (!strSelect[i])
					sb.append(str.charAt(i) + "");
			}
			ans.add(sb.toString());
			return;
		}

		select[idx] = true;
		func(idx + 1, cnt + 1);

		select[idx] = false;
		func(idx + 1, cnt);
	}

	static class Parentheses {
		int start;
		int end;

		public Parentheses(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}