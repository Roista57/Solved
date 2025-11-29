import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine());
			BigInteger a = new BigInteger(st.nextToken(), 2);
			BigInteger b = new BigInteger(st.nextToken(), 2);
			BigInteger sum = a.add(b);
			sb.append(sum.toString(2));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}