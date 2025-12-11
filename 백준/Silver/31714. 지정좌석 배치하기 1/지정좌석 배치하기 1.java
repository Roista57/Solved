import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken()) + D * (i+1);
			}
			Arrays.sort(map[i]);
		}

		boolean flag = true;
		for(int j=0;j<M;j++){
			if(!flag) break;
			for(int i=0;i<N-1;i++){
				if(map[i][j] >= map[i+1][j]){
					flag = false;
					break;
				}
			}
		}
		System.out.println(flag ? "YES" : "NO");
	}
}