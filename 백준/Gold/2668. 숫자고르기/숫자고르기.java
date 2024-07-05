import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectionKey;
import java.util.*;

public class Main {
    static int N;
    static int[] list;
    static boolean[] visited;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        visited = new boolean[N + 1];
        set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            int[] temp = new int[N + 1];
            boolean[] check = new boolean[N + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            check[i] = true;

            while (!queue.isEmpty()) {
                int num = queue.poll();
                temp[num]++;
                temp[list[num]]++;

                if (!check[list[num]]) {
                    queue.offer(list[num]);
                    check[list[num]] = true;
                }
            }
            boolean flag = true;
            for (int j = 1; j <= N; j++) {
                if (temp[j] != 2 && temp[j] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                for (int j = 1; j <= N; j++) {
                    if (temp[j] == 2) {
                        set.add(j);
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}