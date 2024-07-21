import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 3;
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 3; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i];
        }

        System.out.println(dp[N - 1]);

    }
}