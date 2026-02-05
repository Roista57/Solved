import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {-1, 0, +1, 0};
	static int[] dj = {0, +1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] map = new int[r][c];
			char[] list = st.nextToken().toCharArray();
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					map[i][j] = list[c*i+j]-'0';
				}
			}
			int d = 1;
			boolean[][] visited = new boolean[r][c];
			int i = 0;
			int j = 0;
			String ans = "";
			String line = "";
			while(true){
				if(!visited[i][j]){
					visited[i][j] = true;
					line += map[i][j]+"";
					boolean flag = false;
					for(int w=0;w<4;w++){
						int dw = (d + w)%4;
						int ni = i + di[dw];
						int nj = j + dj[dw];
						if(ni >= 0 && ni < r && nj >= 0 && nj < c && !visited[ni][nj]){
							i = ni;
							j = nj;
							flag = true;
							d = dw;
							break;
						}
					}
					if(line.length() == 5){
						ans += func(line);
						line = "";
					}
					if(!flag){
						if(line.length() > 0){
							int n = line.length();
							for(int w=0;w<5-n;w++){
								line += "0";
							}
							ans += func(line);
						}
						break;
					}
				}
			}
			sb.append(ans.trim()).append("\n");
		}
		System.out.println(sb.toString());
	}

	static String func(String line){
		int num = Integer.parseInt(line, 2);
		if(num == 0){
			return " ";
		}else{
			num--;
			return ((char)('A'+num))+"";
		}
	}
}