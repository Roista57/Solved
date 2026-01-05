import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N];
		for(int i=0;i<N;i++){
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		long ans = 0;
		for(int i=0;i<N;i++){
			ans += list[i];
		}
		long max = 0;
		long last = 0;
		long sum = 0;
		for(int i=0;i<N;i++){
			if(last != list[i]){
				max = Math.max(max, sum);
				sum = 0;
				last = list[i];
			}
			sum += list[i];
		}
		max = Math.max(max, sum);
		StringBuilder sb = new StringBuilder();
		sb.append(ans+max).append("\n");
		for(int a : list){
			sb.append(a).append(" ");
		}
		System.out.println(sb.toString());
	}
}