import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int left = 0;
        int right = 0;
        long min = Integer.MAX_VALUE;
        while (right < N) {
            if(M <= (list[right] - list[left]) && left != right){
                min = Math.min(list[right] - list[left], min);
                left++;
            }else {
                right++;
            }
        }
        System.out.println(min);
    }
}