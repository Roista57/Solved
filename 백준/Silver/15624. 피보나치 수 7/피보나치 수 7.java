import java.util.*;
import java.io.*;

public class Main {
	static final int MAX = 1000001;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] list = new long[MAX];
		int N = Integer.parseInt(br.readLine());
		list[1] = 1;
		for(int i=2;i<=N;i++){
			list[i] = (list[i-1] + list[i-2]) % 1000000007;
		}
		System.out.println(list[N]);
	}
}