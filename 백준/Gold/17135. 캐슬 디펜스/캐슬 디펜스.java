import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D;
	static boolean[] combSelect;
	static int[][] map;
	static int[][] temp;
	static boolean[][] select;
	static int MAX;
	static Point[] archers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		combSelect = new boolean[M];

		map = new int[N + 1][M];
		select = new boolean[N + 1][M];
		MAX = Integer.MIN_VALUE;

		archers = new Point[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(MAX);
	}

	static void func(int n, int cnt) {
		if (n == 0) {
			MAX = Math.max(MAX, cnt);
			return;
		}
		for (int p = 0; p < 3; p++) { // 0번 궁수부터 2번 궁수까지
			List<Point> list = new ArrayList<>(); // 적의 위치 정보를 담는 리스트
			for (int d = 1; d <= D; d++) { // 사거리가 1부터 D까지의 탐색
				for (int i = n; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						int len = Math.abs(archers[p].i - i) + Math.abs(archers[p].j - j); // 적과 궁수와의 거리
						// 거리가 d와 같음, 적이 있음, 아처와 같은 행에 있지 않은 경우
						if (len == d && temp[i][j] == 1 && archers[p].i != i) {
							list.add(new Point(i, j, len));
						}
					}
				}
				// 저장된 적중 거리가 짧고 가장 왼쪽에 있는 적을 찾는다.
				if (!list.isEmpty()) {
					Collections.sort(list);
					int i = list.get(0).i;
					int j = list.get(0).j;
					if (!select[i][j])
						cnt++;
					select[i][j] = true;
					break;
				}
			}
		}

		// 궁수에게 공격받은 적을 0으로 만들어줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (select[i][j]) {
					temp[i][j] = 0;
					select[i][j] = false;
				}
			}
		}

		// 궁수의 행을 앞으로 한칸 당겨줌
		for (int p = 0; p < 3; p++) {
			temp[archers[p].i--][archers[p].j] = 0;
			temp[archers[p].i][archers[p].j] = 2;
		}

//		for (int[] a : temp) {
//			System.out.println(Arrays.toString(a));
//		}
//		System.out.println("=====================");
//		System.out.println();

		func(n - 1, cnt);
	}

	static void comb(int idx, int cnt) { // 궁수의 위치를 M개중 3개를 뽑는 조합
		if (cnt == 3) {
			int index = 0;
			temp = copyMap(map);
			for (int i = 0; i < M; i++) {
				if (combSelect[i]) {
					temp[N][i] = 2;
					archers[index++] = new Point(N, i);
				}
			}
//			for (int[] a : temp) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println("=====================");
//			System.out.println();
			func(N, 0);
			return;
		}
		if (idx == M)
			return;

		combSelect[idx] = true;
		comb(idx + 1, cnt + 1);
		combSelect[idx] = false;
		comb(idx + 1, cnt);

	}

	static int[][] copyMap(int[][] arrays) { // 맵 배열 복사
		int[][] temp = new int[arrays.length][arrays[0].length];
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[0].length; j++) {
				temp[i][j] = arrays[i][j];
			}
		}
		return temp;
	}

	static class Point implements Comparable<Point> {
		int i;
		int j;
		int len;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public Point(int i, int j, int len) {
			this.i = i;
			this.j = j;
			this.len = len;
		}

		// 거리를 비교하고 거리가 같다면 j의 값을 비교해 오름차순으로 정렬한다.
		@Override
		public int compareTo(Point o) {
			if (len > o.len) {
				return 1;
			} else if (len == o.len) {
				if (j > o.j) {
					return 1;
				} else if (j == o.j) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}
}