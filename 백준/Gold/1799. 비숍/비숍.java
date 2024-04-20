import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int cnt;
	static int[][] map;

	static int[] di = { -1, +1, -1, +1 };
	static int[] dj = { -1, +1, +1, -1 };

	static Point[] points;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		points = new Point[N * N];
		cnt = 0;

		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				points[idx++] = new Point(i, j);
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func();
	}

	static void func() {
		ArrayList<Node> list;
		int total = 0;
		while (true) {
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						flag = false;
				}
			}
			if (flag)
				break;
			list = new ArrayList<>();
			for (int num = 0; num < N * N; num++) {
				// 대각선
				if (map[points[num].i][points[num].j] == 1) {
					int count = 0;
//					int count = 1;
					boolean cross1 = false;
					for (int k = 1; k <= N; k++) {
						for (int d = 0; d < 2; d++) {
							int ni = points[num].i + di[d] * k;
							int nj = points[num].j + dj[d] * k;
							if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 1) {
//								count++;
								cross1 = true;
							}
						}
					}

					boolean cross2 = false;
					for (int k = 1; k <= N; k++) {
						for (int d = 2; d < 4; d++) {
							int ni = points[num].i + di[d] * k;
							int nj = points[num].j + dj[d] * k;
							if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 1) {
//								count++;
								cross2 = true;
							}
						}
					}

					if (cross1)
						count++;
					if (cross2)
						count++;

					list.add(new Node(num, count));
				}
			}
			Collections.sort(list);
			int num = list.get(0).num;
			map[points[num].i][points[num].j] = 0;
//			System.out
//					.println(points[num].i + ", " + points[num].j + " >> " + list.get(0).num + ", " + list.get(0).cnt);
			// 대각선
			for (int k = 1; k <= N; k++) {
				for (int d = 0; d < 4; d++) {
					int ni = points[num].i + di[d] * k;
					int nj = points[num].j + dj[d] * k;

					if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
						map[ni][nj] = 0;
					}
				}
			}

//			for (int[] a : map) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
			total++;
		}
		System.out.println(total);
	}

	static class Node implements Comparable<Node> {
		int num; //
		int cnt; // 영향을 미치는 개수

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(cnt, o.cnt);
		}
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}