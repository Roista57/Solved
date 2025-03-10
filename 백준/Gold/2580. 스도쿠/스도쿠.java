import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static Point[][] list;
	static final int N = 9;
	static ArrayList<Point> checkList;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		list = new Point[N][N];
		checkList = new ArrayList<Point>();
		flag = false;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new Point(i, j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					insert(i, j);
				}
				if (map[i][j] == 0) {
					checkList.add(list[i][j]);
				}
			}
		}

		func(0, 0);

	}

	static void func(int idx, int cnt) {
		if (flag)
			return;
		
		if (idx == checkList.size()) {
			if (cnt == checkList.size()) {
				for (int[] a : map) {
					for (int b : a) {
						System.out.print(b + " ");
					}
					System.out.println();
				}
				flag = true;
			}
			return;
		}

		Point p = checkList.get(idx);
		for (int k = 1; k <= N; k++) {
			if (list[p.i][p.j].select[k] == 0) {
				map[p.i][p.j] = k;
				insert(p.i, p.j);
				func(idx + 1, cnt + 1);
				remove(p.i, p.j);
				map[p.i][p.j] = 0;
			}
		}
	}

	static void insert(int x, int y) {
		int num = map[x][y];

		for (int k = 0; k < N; k++) {
			if (x + k < N)
				list[x + k][y].select[num]++;
			if (x - k >= 0)
				list[x - k][y].select[num]++;
			if (y + k < N)
				list[x][y + k].select[num]++;
			if (y - k >= 0)
				list[x][y - k].select[num]++;
		}

		int ni = 3 * (x / 3);
		int nj = 3 * (y / 3);
		for (int i = ni; i < 3 + ni; i++) {
			for (int j = nj; j < 3 + nj; j++) {
				list[i][j].select[num]++;
			}
		}
	}

	static void remove(int x, int y) {
		int num = map[x][y];

		for (int k = 0; k < N; k++) {
			if (x + k < N)
				list[x + k][y].select[num]--;
			if (x - k >= 0)
				list[x - k][y].select[num]--;
			if (y + k < N)
				list[x][y + k].select[num]--;
			if (y - k >= 0)
				list[x][y - k].select[num]--;
		}

		int ni = 3 * (x / 3);
		int nj = 3 * (y / 3);

		for (int i = ni; i < 3 + ni; i++) {
			for (int j = nj; j < 3 + nj; j++) {
				list[i][j].select[num]--;
			}
		}
	}

	static class Point {
		int i;
		int j;
		int[] select;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
			this.select = new int[N + 1];
		}
	}

}