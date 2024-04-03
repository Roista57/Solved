import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int NORTH = 0;
	static final int EAST = 2;
	static final int WEST = 6;
	static final int SOUTH = 4;
	static int T;
	static int[][] gears; // 톱니바퀴
	static boolean[] select; // 돌아가는 톱니바퀴
	static int[] states;
	static int K; // 회전하는 톱니바퀴를 고르는 횟수

	static int[] dj = { -1, +1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		gears = new int[T][8];

		for (int i = 0; i < T; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = line.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int state = Integer.parseInt(st.nextToken());

			select = selectGear(num, state);
			for (int i = 0; i < T; i++) {
				rotateGear(i);
			}
		}

		int cnt = 0;
		for (int i = 0; i < T; i++) {
			if (gears[i][NORTH] == 1)
				cnt++;
		}
		System.out.println(cnt);
	}

	static void rotateGear(int num) {
		if (select[num]) {
			if (states[num] == 1) {
				// 시계 방향 회전
				int temp = gears[num][7];
				for (int i = 7; i > 0; i--) {
					gears[num][i] = gears[num][i - 1];
				}
				gears[num][0] = temp;

			} else if (states[num] == -1) {
				// 반 시계 방향 회전
				int temp = gears[num][0];
				for (int i = 0; i < 7; i++) {
					gears[num][i] = gears[num][i + 1];
				}
				gears[num][7] = temp;
			}
		}
	}

	// 움직이는 기어 true 움직이지 않는 기어 false
	static boolean[] selectGear(int number, int state) {
		// 회전 방향 세팅
		states = new int[T];
		if (number % 2 == 0) {
			if (state == 1) {
				for (int i = 0; i < T; i++) {
					if (i % 2 == 0) {
						states[i] = 1;
					} else {
						states[i] = -1;
					}
				}
			} else {
				states = new int[T];
				for (int i = 0; i < T; i++) {
					if (i % 2 == 0) {
						states[i] = -1;
					} else {
						states[i] = 1;
					}
				}
			}
		} else {
			if (state == 1) {
				for (int i = 0; i < T; i++) {
					if (i % 2 == 0) {
						states[i] = -1;
					} else {
						states[i] = 1;
					}
				}
			} else {
				for (int i = 0; i < T; i++) {
					if (i % 2 == 0) {
						states[i] = 1;
					} else {
						states[i] = -1;
					}
				}
			}
		}

		// 회전하는 기어 세팅
		boolean[] temp = new boolean[T];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(number);
		temp[number] = true;

		while (!queue.isEmpty()) {
			int num = queue.poll();

			for (int d = 0; d < 2; d++) {
				int nj = num + dj[d];
				if (nj >= 0 && nj < T && !temp[nj]) {
					if (d == 0) {
						// 왼쪽 톱니를 가져와서 비교
						// 내가 오른쪽에 위치한 톱니
						if (gears[nj][EAST] != gears[num][WEST]) {
							queue.offer(nj);
							temp[nj] = true;
						}

					} else if (d == 1) {
						// 오른쪽 톱니을 가져와서 비교
						// 내가 왼쪽에 위치한 톱니
						if (gears[num][EAST] != gears[nj][WEST]) {
							queue.offer(nj);
							temp[nj] = true;
						}
					}
				}
			}
		}
		return temp;
	}
}