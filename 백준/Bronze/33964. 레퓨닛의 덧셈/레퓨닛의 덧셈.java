import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<Math.abs(X-Y);i++){
			sb.append(1);
		}
		for(int i=0;i<Math.min(X, Y);i++){
			sb.append(2);
		}
		System.out.println(sb.toString());
	}
}