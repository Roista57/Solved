import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] list = new long[N];
		long LCM = 0;
		for(int i=0;i<N;i++){
			list[i] = Long.parseLong(st.nextToken());
			if(i == 0) LCM = list[i];
			else LCM = lcm(LCM, list[i]);
		}
		System.out.println(LCM*2L);
	}

	static long gcd(long a, long b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}

	static long lcm(long a, long b){
		return a * b / gcd(a, b);
	}
}