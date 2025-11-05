import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 3;
		for(int t=0;t<T;t++){
			int N = Integer.parseInt(br.readLine());
			BigInteger sum = new BigInteger("0");
			for(int i=0;i<N;i++){
				sum = sum.add(new BigInteger(br.readLine()));
			}
			if(sum.compareTo(BigInteger.ZERO) == 0){
				System.out.println("0");
			}else if(sum.compareTo(BigInteger.ZERO) > 0){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		}
	}
}