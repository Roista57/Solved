import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long PA = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long PB = Long.parseLong(st.nextToken());

		long[] ans = new long[2];
		long max = 0;

		long HA = N/PA;
		long HB = N%PA/PB;
		while(HA >= 0){
			long cost = (HA*A + HB*B); // cost가 10,000 * 10,000,000 이 될 수 있음.
			if(max < cost){
				ans = new long[] {HA, HB};
				max = cost;
			}
			HA--;
			HB = (N - PA * HA)/PB;
		}
		System.out.println(ans[0]+" "+ans[1]);
	}
}