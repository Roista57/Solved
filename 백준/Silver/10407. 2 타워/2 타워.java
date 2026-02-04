import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger H = new BigInteger(br.readLine());
    System.out.println(H.equals(BigInteger.ONE) ? 2 : 1);
  }
}