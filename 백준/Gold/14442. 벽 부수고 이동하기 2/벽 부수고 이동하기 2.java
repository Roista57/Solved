import java.util.*;
import java.io.*;

public class Main {
	static int[] di = {-1, 0, +1, 0};
	static int[] dj = {0, +1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for(int i=0;i<N;i++){
			String str = br.readLine();
			for(int j=0;j<M;j++){
				map[i][j] = str.charAt(j)-'0';
			}
		}

		boolean[][][] visited = new boolean[N][M][K+1];
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(0, 0, 0));
		visited[0][0][0] = true;

		boolean flag = false;
		int time = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			while(--size >= 0){
				Point p = queue.poll();
				if(p.i == N-1 && p.j == M-1){
					flag = true;
					break;
				}
				for(int d=0;d<4;d++){
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					if(ni >= 0 && ni < N && nj >= 0 && nj < M){
						if(!visited[ni][nj][p.k]){
							if(map[ni][nj] == 0){
								queue.add(new Point(ni, nj, p.k));
								visited[ni][nj][p.k] = true;
							}else{
								if(p.k < K && !visited[ni][nj][p.k+1]){
									queue.add(new Point(ni, nj, p.k+1));
									visited[ni][nj][p.k+1] = true;
								}
							}
						}
					}
				}
			}
			time++;
			if(flag) break;
		}
		if(flag){
			System.out.println(time);
		}else{
			System.out.println(-1);
		}
	}
}

class Point{
	int i, j, k;
	public Point(int i, int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
}