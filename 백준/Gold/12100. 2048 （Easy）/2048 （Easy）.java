import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] list;
	static int MAX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		MAX = 0;
		list = new int[5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);
		per(0);
		System.out.println(MAX);
	}

	static void per(int idx) {
		if (idx == 5) {
			int[][] temp = copy();
			for (int i = 0; i < 5; i++) {
				temp = selectMove(temp, list[i]);
			}
			int num = find(temp);
			MAX = Math.max(MAX, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			list[idx] = i;
			per(idx + 1);
		}
	}

	static int find(int[][] map) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}

	static int[][] copy() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	static int[][] selectMove(int[][] map, int move) {
		if (move == 0) {
			map = up(map);
		} else if (move == 1) {
			map = down(map);
		} else if (move == 2) {
			map = left(map);
		} else if (move == 3) {
			map = right(map);
		}
//		print(map);
		return map;
	}

	static void print(int[][] map) {
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

	static int[][] up(int[][] map) {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
					for (int k = i + 1; k < N; k++) {
						if (map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
				if (i + 1 < N) { // 다음 위치가 N보다 작을 때
					if (map[i + 1][j] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
						for (int k = i + 1; k < N; k++) {
							if (map[k][j] != 0) {
								map[i + 1][j] = map[k][j];
								map[k][j] = 0;
								break;
							}
						}
					}

					// 다음 값이 나랑 같다면 합치기
					if (map[i + 1][j] != 0 && map[i + 1][j] == map[i][j]) {
						map[i][j] += map[i + 1][j];
						map[i + 1][j] = 0;
					}
				}
			}
		}
		return map;
	}

	static int[][] down(int[][] map) {
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (map[i][j] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
				if (i - 1 > 0) { // 다음 위치가 0이상일 때
					if (map[i - 1][j] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
						for (int k = i - 1; k >= 0; k--) {
							if (map[k][j] != 0) {
								map[i - 1][j] = map[k][j];
								map[k][j] = 0;
								break;
							}
						}
					}

					// 다음 값이 나랑 같다면 합치기
					if (map[i - 1][j] != 0 && map[i - 1][j] == map[i][j]) {
						map[i][j] += map[i - 1][j];
						map[i - 1][j] = 0;
					}
				}
			}
		}
		return map;
	}

	static int[][] right(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
					for (int k = j - 1; k >= 0; k--) {
						if (map[i][k] != 0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							break;
						}
					}
				}
				if (j - 1 >= 0) { // 다음 위치가 N보다 작을 때
					if (map[i][j - 1] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] != 0) {
								map[i][j - 1] = map[i][k];
								map[i][k] = 0;
								break;
							}
						}
					}

					// 다음 값이 나랑 같다면 합치기
					if (map[i][j - 1] != 0 && map[i][j - 1] == map[i][j]) {
						map[i][j] += map[i][j - 1];
						map[i][j - 1] = 0;
					}
				}
			}
		}
		return map;
	}

	static int[][] left(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
					for (int k = j + 1; k < N; k++) {
						if (map[i][k] != 0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							break;
						}
					}
				}
				if (j + 1 < N) { // 다음 위치가 N보다 작을 때
					if (map[i][j + 1] == 0) { // 현재 위치의 값이 0 이라면 아래에 0이 아닌 다른 값이 있는지 보고 있다면 가져오기
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] != 0) {
								map[i][j + 1] = map[i][k];
								map[i][k] = 0;
								break;
							}
						}
					}

					// 다음 값이 나랑 같다면 합치기
					if (map[i][j + 1] != 0 && map[i][j + 1] == map[i][j]) {
						map[i][j] += map[i][j + 1];
						map[i][j + 1] = 0;
					}
				}
			}
		}
		return map;
	}

}