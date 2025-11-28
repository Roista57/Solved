import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int cnt;
	static boolean[][] keyInfo;
	static boolean[] select;
	static boolean[][][] visited;
	static char[][] map;
	static Point minsik;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		select = new boolean[6];
		keyInfo = new boolean[64][6];
		visited = new boolean[64][N][M];
		map = new char[N][M];
		subset(0);

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					map[i][j] = '.';
					minsik = new Point(i, j, new boolean[6]);
				}
			}
		}
		System.out.println(bfs(minsik));
	}

	static int bfs(Point start) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[keyNumber(start.keys)][start.i][start.j] = true;
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point p = queue.poll();

//				System.out.print("---- ");
//				for (int i = 0; i < p.keys.length; i++) {
//					if (p.keys[i])
//						System.out.print((char) ('a' + i) + " ");
//				}
//				System.out.println("----");
//
//				for (boolean[] a : visited[keyNumber(p.keys)]) {
//					for (boolean b : a) {
//						if (b)
//							System.out.print("1 ");
//						else
//							System.out.print("0 ");
//					}
//					System.out.println();
//				}
//				System.out.println();

				for (int d = 0; d < 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
						if (!visited[keyNumber(p.keys)][ni][nj]) {
							boolean[] temp = keyCopy(p.keys);
							if (map[ni][nj] == '#') {
								continue;
							} else if (map[ni][nj] == 'a' || map[ni][nj] == 'b' || map[ni][nj] == 'c'
									|| map[ni][nj] == 'd' || map[ni][nj] == 'e' || map[ni][nj] == 'f') {
//								System.out.print(
//										"[" + map[ni][nj] + "]" + keyNumber(p.keys) + ", " + ni + ", " + nj + " >> ");
								temp[map[ni][nj] - 'a'] = true;
//								System.out.println(keyNumber(p.keys) + ", " + ni + ", " + nj);
								visited[keyNumber(p.keys)][ni][nj] = true;
								queue.offer(new Point(ni, nj, temp));
							} else if (map[ni][nj] == 'A' || map[ni][nj] == 'B' || map[ni][nj] == 'C'
									|| map[ni][nj] == 'D' || map[ni][nj] == 'E' || map[ni][nj] == 'F') {
								if (p.keys[map[ni][nj] - 'A']) {

//									System.out.println(map[ni][nj] + " >> " + p.keys[map[ni][nj] - 'A']);
									queue.offer(new Point(ni, nj, temp));
									visited[keyNumber(p.keys)][ni][nj] = true;
								}
							} else if (map[ni][nj] == '1') {
								return time + 1;
							} else if (map[ni][nj] == '.') {
								queue.offer(new Point(ni, nj, temp));
								visited[keyNumber(p.keys)][ni][nj] = true;
							}
						}
					}
				}
			}
			time++;
		}
		return -1;
	}

	static boolean[] keyCopy(boolean[] keys) {
		boolean[] temp = new boolean[6];
		for (int i = 0; i < 6; i++) {
			temp[i] = keys[i];
		}
		return temp;
	}

	static void subset(int idx) {
		if (idx == 6) {
			for (int i = 0; i < 6; i++) {
				if (select[i])
					keyInfo[cnt][i] = select[i];
			}
			cnt++;
			return;
		}

		select[idx] = true;
		subset(idx + 1);
		select[idx] = false;
		subset(idx + 1);
	}

	static int keyNumber(boolean[] myKey) {
		for (int i = 63; i >= 0; i--) {
			int cnt = 0;
			for (int j = 0; j < 6; j++) {
				if (keyInfo[i][j] == myKey[j])
					cnt++;
			}
			if (cnt == 6)
				return i;
		}
		return -1;
	}

	static class Point {
		int i;
		int j;
		boolean[] keys;

		public Point(int i, int j, boolean[] keys) {
			super();
			this.i = i;
			this.j = j;
			this.keys = keys;
		}
	}
}