import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		int N = line.length;
		int ans = 0;
		for(int i=0;i<N;i++){
			int num = line[i] - '0';
			if(num > 4) num--;
			ans += num * (int) Math.pow(9, N-(i+1));
		}
		System.out.println(ans);
	}
}