import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] list;
    static boolean[] select;
    static int[] nums;
    static long min;
    static String minSt;
    static long max;
    static String maxSt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        list = new String[K];
        select = new boolean[10];
        nums = new int[K + 1];
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            list[i] = st.nextToken();
        }
        func(0);
        System.out.println(maxSt);
        System.out.println(minSt);
    }

    static void func(int cnt) {
        if (cnt == (K + 1)) {
            boolean flag = true;
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals("<")) {
                    if (nums[i] > nums[i + 1]) {
                        flag = false;
                    }
                } else {
                    if (nums[i] < nums[i + 1]) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                String st = "";
                for (int i = 0; i < nums.length; i++) {
                    st += nums[i];
                }
                long number = Long.parseLong(st);
                if (min > number) {
                    min = number;
                    minSt = st;
                }
                if (max < number) {
                    max = number;
                    maxSt = st;
                }
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!select[i]) {
                select[i] = true;
                nums[cnt] = i;
                func(cnt + 1);
                select[i] = false;
            }
        }
    }
}