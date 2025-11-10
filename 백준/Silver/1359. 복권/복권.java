import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 전체 경우의 수
		double nCm = combination(N, M);
		double sum = 0;
		// K개 겹치는 개수부터 M개 겹치는 개수까지 합침.
		for(int i=K;i<=M;i++){
			sum += (combination(M, i) * combination(N - M, M - i));
		}
		System.out.println(sum/nCm);
	}

	static double combination(int a, int b){
		double comb = 1;
		double temp = 1;
		for(int i=0;i<b;i++){
			temp *= (i + 1);
			comb *= (a - i);
		}
		comb = comb / temp;
		return comb;
	}
}