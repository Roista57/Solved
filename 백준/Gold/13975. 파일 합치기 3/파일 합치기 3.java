import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Queue<Long> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            queue = new PriorityQueue<>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    if (o1 > o2) {
                        return 1;
                    } else if (o1.equals(o2)) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (!queue.isEmpty()) {
                long a = queue.poll();
                if (queue.isEmpty()) {
                    System.out.println(sum);
                    break;
                }
                long b = queue.poll();
                long c = a + b;
                sum += c;
                queue.offer(c);
            }
        }
    }
}