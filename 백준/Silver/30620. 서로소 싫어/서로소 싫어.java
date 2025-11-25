import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		int M = 0;
		long[] list = new long[2];

		if(X != Y){
			if(gcd(X, Y) > 1){
				M = 1;
				list[0] = Y - X;
			}else{
				M = 2;
				long z1 = lcm(X, Y) - X;
				long x1 = X + z1;
				list[0] = z1;

				long z2 = lcm(X, Y) - Y;
				long x2 = x1 - z2;
				list[1] = -z2;
			}
		}
		System.out.println(M);
		for(int i=0;i<M;i++){
			System.out.println(list[i]);
		}
	}

	static long gcd(long a, long b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}

	static long lcm(long a, long b){
		return a * b / gcd(a, b);
	}
}