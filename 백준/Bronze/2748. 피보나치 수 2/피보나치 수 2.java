import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = func(i - 1) + func(i - 2);
        }
        System.out.println(dp[N]);
    }

    static long func(int n) {
        if(dp[n] != 0 || n == 0 || n == 1){
            return dp[n];
        }
        return func(n-1) + func(n-2);
    }
}