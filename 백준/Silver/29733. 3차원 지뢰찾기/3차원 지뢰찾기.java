import java.util.*;
import java.io.*;

public class Main {
	static int R;
	static int C;
	static int H;
	static char[][][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 높이

		map = new char[H][R][C];
		StringBuilder sb = new StringBuilder();

		int[][][] ans = new int[H][R][C];

		for(int i=0;i<H;i++){
			for(int j=0;j<R;j++){
				map[i][j] = br.readLine().toCharArray();
			}
		}

		for(int i=0;i<H;i++){
			for(int j=0;j<R;j++){
				for(int w=0;w<C;w++){
					if(map[i][j][w] == '*') continue;
					ans[i][j][w] = func(i, j, w);
				}
			}
		}

		for(int i=0;i<H;i++){
			for(int j=0;j<R;j++){
				for(int w=0;w<C;w++){
					if(map[i][j][w] == '*') sb.append(map[i][j][w]);
					else sb.append(ans[i][j][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());


	}

	static int func(int h, int r, int c){
		int cnt = 0;
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				for(int w=-1;w<=1;w++){
					int ni = h + i;
					int nj = r + j;
					int nw = c + w;

					if(ni == h && nj == r && nw == c) continue;
					if(ni < 0 || ni >= H || nj < 0 || nj >= R || nw < 0 || nw >= C) continue;
					if(map[ni][nj][nw] == '*') cnt++;
				}
			}
		}
		return cnt % 10;
	}
}