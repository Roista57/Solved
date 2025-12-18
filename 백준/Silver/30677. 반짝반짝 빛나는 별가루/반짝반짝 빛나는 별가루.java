import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken()); // 상수
		int R = Integer.parseInt(st.nextToken()); // 휴식시 줄어드는 피로도

		int[] base = new int[K+1]; // 기본 별가루 개수
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=K;i++){
			base[i] = Integer.parseInt(st.nextToken());
		}
		int[] s = new int[K+1]; // 상수
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=K;i++){
			s[i] = Integer.parseInt(st.nextToken());
		}
		int[] p = new int[K+1]; // 피로도
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=K;i++){
			p[i] = Integer.parseInt(st.nextToken());
		}
		int[] skill = new int[K+1];

		long ans = 0;
		int combo = 0;
		int energy = 0;
		for(int i=0;i<N;i++){
			int mg = Integer.parseInt(br.readLine());
			if(mg != 0){
				// double로 했을 때 안됬으니 더 정확하게
				BigDecimal temp1 = BigDecimal.valueOf(combo).multiply(BigDecimal.valueOf(C)).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
				BigDecimal temp2 = BigDecimal.valueOf(skill[mg]).multiply(BigDecimal.valueOf(s[mg])).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
				BigDecimal stardust = BigDecimal.valueOf(base[mg]).multiply(temp1).multiply(temp2);
				ans += stardust.longValue();
				combo++;
				skill[mg]++;
				energy += p[mg];
			}else{
				combo = 0;
				energy = Math.max(0, energy - R);
			}
			if(energy > 100){
				ans = -1;
				break;
			}
		}
		System.out.println(ans);
	}
}