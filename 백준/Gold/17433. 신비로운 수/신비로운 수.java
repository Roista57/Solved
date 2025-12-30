import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] list = new int[N];
			for(int i=0;i<N;i++){
				list[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);
			if(list[0] != list[N-1]){
				int stand = list[0];
				int[] temp = new int[N-1];
				for(int i=1;i<N;i++){
					temp[i-1] = Math.abs(list[i] - stand);
				}
				int ans = temp[0];
				for(int i=1;i<N-1;i++){
					int a = Math.max(ans, temp[i]);
					int b = Math.min(ans, temp[i]);
					ans = gcd(a, b);
				}
				sb.append(ans).append("\n");
			}else{
				sb.append("INFINITY").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}