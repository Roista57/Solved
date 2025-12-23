import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		long idx = 1;
		long a = 0;
		long b = 1;
		for(int q=0;q<Q;q++){
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if(type == 0){
				a += Integer.parseInt(st.nextToken());
			}else if(type == 1){
				int num = Integer.parseInt(st.nextToken());
				b *= num;
				a *= num;
			}else if(type == 2){
				idx += Integer.parseInt(st.nextToken());
			}else{
				sb.append(idx * b + a).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}