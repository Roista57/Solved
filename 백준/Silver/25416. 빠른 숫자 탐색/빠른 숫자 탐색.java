import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {-1, 0, +1, 0};
	static int[] dj = {0, +1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = 5;
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(r, c));
		visited[r][c] = true;

		boolean flag = false;
		int time = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			while(--size >= 0){
				Point p = queue.poll();

				if(map[p.i][p.j] == 1){
					flag = true;
					break;
				}
				for(int d=0;d<4;d++){
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if(ni >= 0 && ni < N && nj >=0 && nj < N && !visited[ni][nj] && map[ni][nj] != -1){
						queue.add(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
			if(flag) break;
			time++;
		}
		if(flag){
			System.out.println(time);
		}else{
			System.out.println("-1");
		}
	}
}

class Point{
	int i;
	int j;
	public Point(int i, int j){
		this.i = i;
		this.j = j;
	}
}