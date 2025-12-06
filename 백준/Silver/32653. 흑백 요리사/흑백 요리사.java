import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long LCM = 1;
		for(int i=0;i<N;i++){
			LCM = lcm(LCM, Long.parseLong(st.nextToken()));
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