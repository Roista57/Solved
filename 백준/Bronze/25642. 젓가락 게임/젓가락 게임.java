import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while(a < 5 && b < 5){
			if(cnt % 2 == 0){
				b += a;
			}else{
				a += b;
			}
			cnt++;
		}
		System.out.println(b >= 5 ? "yt" : "yj");
	}
}