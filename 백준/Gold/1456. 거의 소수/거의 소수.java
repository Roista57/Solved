import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long S = Long.parseLong(st.nextToken());
        long E = Long.parseLong(st.nextToken());
        int MAX = 10000001;

        HashSet<Long> set = new HashSet<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        boolean[] list = new boolean[MAX];
        boolean[] ans = new boolean[MAX];
        for (int i = 2; i < MAX; i++) {
            if (!list[i]) {
                list2.add(i);
                for (int j = 2; j < MAX / 2; j++) {
                    int num = i * j;
                    if (num >= MAX) {
                        break;
                    }
                    if (!list[num]) {
                        list[num] = true;
                    }
                }
            }
        }
        int END = (int) Math.sqrt(E);

        for (int i = 2; i <= END; i++) {
            if (!list[i]) {
                for (int j = 2; j < 50; j++) {
                    double pow = Math.pow(i, j);
                    if (pow > E) {
                        break;
                    }
                    if (pow >= S) {
                        set.add((long) pow);
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}