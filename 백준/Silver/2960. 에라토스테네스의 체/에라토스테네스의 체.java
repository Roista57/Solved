import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int ans = 0;
		boolean flag = false;

		boolean[] list = new boolean[N+1];
		Arrays.fill(list, true);

		for(int i=2;i<=N;i++){
			if(flag) break;
			if(!list[i]) continue;
			int idx = i;
			while(idx <= N){
				if(list[idx]){
					list[idx] = false;
					if(++cnt == K){
						ans = idx;
						flag = true;
						break;
					}
				}
				idx += i;
			}
		}
		System.out.println(ans);
	}
}