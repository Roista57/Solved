import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int temp = Integer.parseInt(a.charAt(i) + "") * Integer.parseInt(b.charAt(j) + "");
                sum = sum.add(BigInteger.valueOf(temp));
            }
        }
        System.out.println(sum);


    }
}