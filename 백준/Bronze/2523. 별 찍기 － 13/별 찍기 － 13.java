import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N*2-1;i++){
			for(int j=0;j<N - Math.abs(i-N);j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}