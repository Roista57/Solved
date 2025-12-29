import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] list = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++){
			list[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++){
			int min = Integer.MAX_VALUE;
			int max = 0;
			for(int j=i;j>0;j--){
				if(min > list[j]) min = list[j];
				if(max < list[j]) max = list[j];
				dp[i] = Math.max(dp[i], dp[j-1] + (max - min));
			}
		}
		System.out.println(dp[N]);
	}
}