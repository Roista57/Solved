import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		if(X > Y){
			for(int i=0;i<X-Y;i++){
				sb.append("1");
			}
			for(int i=0;i<Y;i++){
				sb.append("2");
			}
		}else{
			for(int i=0;i<Y-X;i++){
				sb.append("1");
			}
			for(int i=0;i<X;i++){
				sb.append("2");
			}
		}
		System.out.println(sb.toString());
	}
}