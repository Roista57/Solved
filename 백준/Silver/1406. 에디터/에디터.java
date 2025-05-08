import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			leftStack.add(str.charAt(i));
		}

		int cursor = str.length();
		int size = cursor;

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);

			if (command == 'L') {
				// 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
				if (cursor > 0) {
					cursor--;
					rightStack.add(leftStack.pop());
				}

			} else if (command == 'D') {
				// 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
				if (cursor < size) {
					cursor++;
					leftStack.add(rightStack.pop());
				}

			} else if (command == 'B') {
				// 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
				// 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
				if (cursor > 0) {
					leftStack.pop();
					cursor--;
					size--;
				}
			} else if (command == 'P') {
				// $라는 문자를 커서 왼쪽에 추가함
				leftStack.add(st.nextToken().charAt(0));
				cursor++;
				size++;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!leftStack.isEmpty()) {
			sb.append(leftStack.pop());
		}
		sb.reverse();
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb.toString());
	}
}