import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigDecimal a = BigDecimal.valueOf(Double.parseDouble(st.nextToken()));
		int b = Integer.parseInt(st.nextToken());
		
		BigDecimal ans = a.pow(b);
		System.out.println(ans.toPlainString());
	}

}