import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i=0;i<N;i++){
			int idx = 0;
			int[] cnt = new int[3];
			int last = map[i][0];
			if(last != 0) cnt[last]++;
			while(++idx <= M){
				if(map[i][idx] == 0){
					int min = Math.min(cnt[1], cnt[2]);
					int max = Math.max(cnt[1], cnt[2]);
					if(max != 0){
						if(min == 0) ans++;
						else if(min > 0){
							ans += min + 1;
						}
					}
					cnt[1] = 0;
					cnt[2] = 0;
				}else if(map[i][idx] != last){
					cnt[map[i][idx]]++;
				}
				last = map[i][idx];
			}
		}
		System.out.println(ans);
	}
}