import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 2) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(Integer.parseInt(st.nextToken()));
            } else {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop() + "\n");
                    } else {
                        sb.append("-1\n");
                    }
                } else if (num == 3) {
                    sb.append(stack.size() + "\n");
                } else if (num == 4) {
                    if (stack.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                } else if (num == 5) {
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek() + "\n");
                    } else {
                        sb.append("-1\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}