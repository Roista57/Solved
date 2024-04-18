import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		if (a.equals(BigInteger.ONE)) {
			System.out.println("1");
		} else {
			a = a.multiply(BigInteger.TWO);
			System.out.println(a.subtract(BigInteger.TWO));
		}

	}
}