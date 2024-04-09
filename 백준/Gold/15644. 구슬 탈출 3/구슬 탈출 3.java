import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static Point R;
	static Point B;
	static Point O;
	static int min;
	static int[] list;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[10];
		ans = new int[10];
		min = Integer.MAX_VALUE;

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = line.charAt(j);
				map[i][j] = ch;
				if (map[i][j] == 'R') {
					R = new Point('R', i, j);
				} else if (map[i][j] == 'B') {
					B = new Point('B', i, j);
				} else if (map[i][j] == 'O') {
					O = new Point('O', i, j);
				} else {
					map[i][j] = ch;
				}
			}
		}
		per(0, 4);

		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
			for (int i = 0; i < min; i++) {
				if (ans[i] == 0) {
					System.out.print("U");
				} else if (ans[i] == 1) {
					System.out.print("D");
				} else if (ans[i] == 2) {
					System.out.print("L");
				} else if (ans[i] == 3) {
					System.out.print("R");
				}
			}
		}
	}

	static void per(int idx, int num) {
		if (idx == 10) {
			char[][] temp = copy(map);
			Point r = new Point(R.name, R.i, R.j);
			Point b = new Point(B.name, B.i, B.j);
			for (int k = 0; k < list.length; k++) {
				if (k + 1 > min)
					return;
				if (list[k] == 0) {
					if (r.j == b.j) {
						if (r.i < b.i) {
							r = up(r, temp);
							b = up(b, temp);
						} else {
							b = up(b, temp);
							r = up(r, temp);
						}
					} else {
						r = up(r, temp);
						b = up(b, temp);
					}

				} else if (list[k] == 1) {
					if (r.j == b.j) {
						if (r.i < b.i) {
							b = down(b, temp);
							r = down(r, temp);
						} else {
							r = down(r, temp);
							b = down(b, temp);
						}
					} else {
						r = down(r, temp);
						b = down(b, temp);
					}
				} else if (list[k] == 2) {
					if (r.i == b.i) {
						if (r.j < b.j) {
							r = left(r, temp);
							b = left(b, temp);
						} else {
							b = left(b, temp);
							r = left(r, temp);
						}
					} else {
						r = left(r, temp);
						b = left(b, temp);
					}
				} else if (list[k] == 3) {
					if (r.i == b.i) {
						if (r.j < b.j) {
							b = right(b, temp);
							r = right(r, temp);
						} else {
							r = right(r, temp);
							b = right(b, temp);
						}
					} else {
						r = right(r, temp);
						b = right(b, temp);
					}
				}

				boolean flagR = true;
				boolean flagB = true;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (temp[i][j] == 'R')
							flagR = false;
						if (temp[i][j] == 'B')
							flagB = false;
					}
				}
				if (flagB && !flagR || flagB && flagR)
					return;
				if (flagR && !flagB) {
					if (min > k + 1) {
						min = k + 1;
						for (int d = 0; d < list.length; d++) {
							ans[d] = list[d];
						}
					}
					return;
				}
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (num != i) {
				list[idx] = i;
				per(idx + 1, i);
			}
		}
	}

	static void print(char[][] map) {
		for (char[] a : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

	static char[][] copy(char[][] map) {
		char[][] temp = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	static Point up(Point p, char[][] map) {
		if (map[p.i][p.j] == 'O')
			return p;
		int i = p.i;
		while (true) {
			if (map[i - 1][p.j] == '.') {
				i--;
				continue;
			} else if (map[i - 1][p.j] == 'O') {
				map[p.i][p.j] = '.';
				p.i = i - 1;
				return p;
			} else {
				break;
			}
		}
		map[p.i][p.j] = '.';
		p.i = i;
		map[p.i][p.j] = p.name;
		return p;
	}

	static Point down(Point p, char[][] map) {
		if (map[p.i][p.j] == 'O')
			return p;
		int i = p.i;
		while (true) {
			if (map[i + 1][p.j] == '.') {
				i++;
				continue;
			} else if (map[i + 1][p.j] == 'O') {
				map[p.i][p.j] = '.';
				p.i = i + 1;
				return p;
			} else {
				break;
			}
		}
		map[p.i][p.j] = '.';
		p.i = i;
		map[p.i][p.j] = p.name;
		return p;
	}

	static Point left(Point p, char[][] map) {
		if (map[p.i][p.j] == 'O')
			return p;
		int j = p.j;
		while (true) {
			if (map[p.i][j - 1] == '.') {
				j--;
				continue;
			} else if (map[p.i][j - 1] == 'O') {
				map[p.i][p.j] = '.';
				p.j = j - 1;
				return p;
			} else {
				break;
			}
		}
		map[p.i][p.j] = '.';
		p.j = j;
		map[p.i][p.j] = p.name;
		return p;
	}

	static Point right(Point p, char[][] map) {
		if (map[p.i][p.j] == 'O')
			return p;
		int j = p.j;
		while (true) {
			if (map[p.i][j + 1] == '.') {
				j++;
				continue;
			} else if (map[p.i][j + 1] == 'O') {
				map[p.i][p.j] = '.';
				p.j = j + 1;
				return p;
			} else {
				break;
			}
		}
		map[p.i][p.j] = '.';
		p.j = j;
		map[p.i][p.j] = p.name;
		return p;
	}

	static class Point {
		char name;
		int i;
		int j;

		public Point(char name, int i, int j) {
			this.name = name;
			this.i = i;
			this.j = j;
		}
	}
}