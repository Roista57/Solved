import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static boolean[] select;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		select = new boolean[N];
		ans = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0, 0);
		System.out.println(ans);
	}

	static void func(int idx, int cnt){
		if(cnt == K){
			int sum = 0;
			int num = 0;
			int[] list = new int[K];
			for(int i=0;i<N;i++){
				if(select[i]) list[num++] = i;
			}
			for(int i=0;i<K;i++){
				for(int j=i+1;j<K;j++){
					sum += map[list[i]][list[j]];
				}
			}
			ans = Math.max(ans, sum);
			return;
		}
		if(idx == N) return;

		select[idx] = true;
		func(idx+1, cnt+1);

		select[idx] = false;
		func(idx+1, cnt);
	}
}