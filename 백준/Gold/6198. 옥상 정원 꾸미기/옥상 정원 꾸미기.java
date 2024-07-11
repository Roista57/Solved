import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int N;
    static int[] list;
    static int[] ans;
    static long total = 0;
    static Stack<int[]> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            list[i] = num;
        }

        for (int i = 0; i < N; i++) {
            if (!stack.empty()) {
                while (!stack.empty() && stack.peek()[0] <= list[i]) {
                    int[] arr = stack.pop();
                    long cnt = i - arr[1] - 1;
                    total += cnt;
                }
            }
            stack.push(new int[]{list[i], i});
        }
        if (!stack.empty()) {
            int[] node = stack.pop();
            while (!stack.empty()) {
                int[] arr = stack.pop();
                long cnt = node[1] - arr[1];
                total += cnt;
            }
        }
        System.out.println(total);

    }
}