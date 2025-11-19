import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i=1;i<=K;i++){
			max = Math.max(max, Integer.parseInt(new StringBuilder(N*i+"").reverse().toString()));
		}
		System.out.println(max);
	}
}