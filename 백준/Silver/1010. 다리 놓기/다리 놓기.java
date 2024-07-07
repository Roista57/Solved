import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[31];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i < 31; i++) {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M].divide((dp[(M-N)].multiply(dp[N]))));
        }
    }
}