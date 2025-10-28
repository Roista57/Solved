import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int weight = 0;
		int total = 0;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			if(type.equals("A")){
				int cnt = (W/12) * (H/12) * (L/12);
				total += cnt;
				weight += 1000 + cnt * 500;
			}else{
				weight += 6000;
			}
		}
		System.out.println(weight);
		System.out.println(total*4000);
	}
}