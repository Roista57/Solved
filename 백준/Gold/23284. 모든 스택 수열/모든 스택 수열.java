import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	static int N;
	static Stack<Character> inStack;
	static TreeSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inStack = new Stack<Character>();
		set = new TreeSet<String>();
		func(0, "");

		StringBuilder sb = new StringBuilder();
		for (String str : set) {
			for (int i = 0; i < N; i++) {
				sb.append((str.charAt(i) - 'A') + 1 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void func(int idx, String str) {
		if (idx == N) {
			for (int i = inStack.size() - 1; i >= 0; i--) {
				str += inStack.get(i);
			}
			set.add(str);
			return;
		}

		if (idx < N) {
			inStack.push((char) ('A' + idx));
			func(idx + 1, str);
			inStack.pop();
		}

		if (!inStack.isEmpty()) {
			char ch = inStack.pop();
			func(idx, str + ch);
			inStack.push(ch);
		}
	}
}