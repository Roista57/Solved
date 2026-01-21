import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[][] map = new char[H][];
		for(int i=0;i<H;i++){
			map[i] = br.readLine().toCharArray();
		}

		int[][] ans = new int[H][W];

		for(int i=0;i<H;i++){
			int cnt = -1;
			for(int j=0;j<W;j++){
				if(map[i][j] == 'c') cnt = 0;
				else if(cnt != -1) cnt++;
				ans[i][j] = cnt;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				sb.append(ans[i][j]);
				if(j < W-1) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}