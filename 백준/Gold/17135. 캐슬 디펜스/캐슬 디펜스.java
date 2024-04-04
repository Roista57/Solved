import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int D;

	static int[] di = { 0, -1, 0 };
	static int[] dj = { -1, 0, +1 };

	static int[] select;
	static int max;

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M]; // 맵 가장 아래에 궁수를 둘거라 1 키워서 만들었음.
		select = new int[3];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(max);
	}

	static Point find(Point start, int[][] map) {
		boolean[][] visited = new boolean[N + 1][M];

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.i][start.j] = true;

		int len = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (--size >= 0) {
				Point p = queue.poll();
				for (int d = 0; d < 3; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if (ni >= 0 && ni <= N && nj >= 0 && nj < M && !visited[ni][nj]) {
						if (map[ni][nj] == 1) {
							return new Point(ni, nj);
						}
						visited[ni][nj] = true;
						queue.offer(new Point(ni, nj));
					}
				}
			}
			len++;
			if (len > D)
				break;
		}
		return null;
	}

	static int func() {
		int total = 0;
		int[][] map = mapCopy();
		for (int k = 0; k < N; k++) {
			ArrayList<Point> list = new ArrayList<>();
			// 사정거리에 있는 적 찾음
			for (int i = 0; i < 3; i++) {
				Point point = find(new Point(N, select[i]), map);
				if (point != null)
					list.add(point);
			}

			// 적 제거
			for (int i = 0; i < list.size(); i++) {
				Point p = list.get(i);
				if (map[p.i][p.j] == 1) {
					map[p.i][p.j] = 0;
					total++;
				}
			}
			down(map);
		}
		return total;
	}

	static void down(int[][] map) {
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (i == 0)
					map[i][j] = 0;
				else
					map[i][j] = map[i - 1][j];
			}
		}
	}

	static void comb(int idx, int cnt) {
		if (cnt == 3) {
			// 궁수를 뽑아주고 맵에 세팅
			int num = func();
			max = Math.max(max, num);
			return;
		}

		if (idx == M)
			return;

		select[cnt] = idx;
		comb(idx + 1, cnt + 1);
		select[cnt] = 0;
		comb(idx + 1, cnt);
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[][] mapCopy() {
		int[][] temp = new int[N + 1][M];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}