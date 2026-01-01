import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BigInteger[] list = new BigInteger[491];
		list[0] = BigInteger.ZERO;
		list[1] = BigInteger.ONE;
		list[2] = new BigInteger("2");
		for(int i=3;i<list.length;i++){
			list[i] = list[i-1].add(list[i-2]);
		}

		while(true){
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if(a.equals("0") && b.equals("0")) break;

			BigInteger A = new BigInteger(a);
			BigInteger B = new BigInteger(b);

			int start = 0;
			int end = 0;
			for(int i=1;i<list.length;i++){
				if(start == 0 && A.compareTo(list[i]) <= 0){
					start = i;
				}
				if(end == 0 && B.compareTo(list[i]) < 0){
					end = i;
				}
				if(start != 0 && end != 0) break;
			}
			System.out.println(end - start);
		}
	}
}