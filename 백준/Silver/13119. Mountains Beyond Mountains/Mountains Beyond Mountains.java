import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for(int i=0;i<N;i++){
			if(N - X == i) Arrays.fill(map[i], '-');
			else Arrays.fill(map[i], '.');
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
			int h = Integer.parseInt(st.nextToken());
			for(int j=1;j<=h;j++){
				if(map[N-j][i] == '-') map[N-j][i] = '*';
				else map[N-j][i] = '#';
			}
		}

		for(int j=1;j<=M;j++){
			if(j % 3 == 0){
				int idx = N-X+1;
				while(idx < N){
					if(map[idx][j-1] == '#') break;
					map[idx++][j-1] = '|';
				}
			}
		}

		for(char[] a : map){
			for(char b : a){
				sb.append(b);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}