import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] A = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] B = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      B[i] = Integer.parseInt(st.nextToken());
    }

    long[][] dp = new long[2][N];
    dp[0][0] = A[0];
    dp[1][0] = B[0];
    for(int i=1;i<N;i++){
      dp[0][i] = Math.min(dp[0][i-1]+A[i], dp[1][i-1]+A[i]+K);
      dp[1][i] = Math.min(dp[0][i-1]+B[i]+K, dp[1][i-1]+B[i]);
    }

    System.out.println(Math.min(dp[0][N-1], dp[1][N-1]));
  }
}