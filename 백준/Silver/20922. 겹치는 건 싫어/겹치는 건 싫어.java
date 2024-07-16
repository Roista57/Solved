import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] list;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N];
        cnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();

        int right = 0;
        int len = 0;
        int max = 0;
        while (right < N) {
            if (cnt[list[right]] < K) {
                queue.offer(list[right]);
                cnt[list[right]]++;
                right++;
                len++;
            } else if (!queue.isEmpty()) {
                cnt[queue.peek()]--;
                queue.poll();
                len--;
            }
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
}