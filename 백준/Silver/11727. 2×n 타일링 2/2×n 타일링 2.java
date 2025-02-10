import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		BigInteger[] list = new BigInteger[1001];
		list[0] = BigInteger.ZERO;
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i < 1001; i++) {
			sum = sum.add(list[i - 1]);
			if (i % 2 == 1) {
				list[i] = sum.add(BigInteger.ONE);
			} else {
				list[i] = sum.add(BigInteger.TWO);
			}
		}
		System.out.println(list[n].mod(BigInteger.valueOf(10007)));
	}
}