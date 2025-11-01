import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int sum = 0;
		for(int i=0;i<N;i++){
			int temp = Integer.parseInt(st.nextToken());
			sum += temp;
			max = Math.max(max, temp);
		}
		System.out.println(sum - max);
	}
}