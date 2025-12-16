import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int MAX = K;
		int cnt = 0;
		for(int i=2;i<MAX;i++){
			while(K % i == 0){
				K /= i;
				cnt++;
			}
		}
		int T = 0;
		while(Math.pow(2, T) < cnt){
			T++;
		}
		System.out.println(T);
	}
}