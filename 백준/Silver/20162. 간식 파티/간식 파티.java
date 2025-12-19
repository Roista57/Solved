import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		for(int i=0;i<N;i++){
			list[i] = Integer.parseInt(br.readLine());
		}
		int[] sum = new int[N];
		int ans = 0;
		for(int i=0;i<N;i++){
			int max = 0;
			for(int j=0;j<i;j++){
				if(list[i] > list[j]) max = Math.max(max, sum[j]);
			}

			sum[i] = list[i] + max;
			ans = Math.max(ans, sum[i]);
		}
		// System.out.println(Arrays.toString(sum));
		System.out.println(ans);
	}
}