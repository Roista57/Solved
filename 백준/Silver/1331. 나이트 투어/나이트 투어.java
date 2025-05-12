import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] list;
	static boolean[][] visited;

	static int[] di = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dj = { 1, -1, -2, -2, -1, 1, 2, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		list = new char[36][2];
		visited = new boolean[6][6];
		boolean check = true;

		for (int i = 0; i < 36; i++) {
			list[i] = br.readLine().toCharArray();
		}
		Point p = charToPoint(list[0]);
		visited[p.i][p.j] = true;

		for (int i = 1; i < 36; i++) {
			Point move = charToPoint(list[i]);
			boolean flag = false;
			for (int d = 0; d < 8; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if (ni >= 0 && ni < 6 && nj >= 0 && nj < 6 && !visited[ni][nj]) {
					if (ni == move.i && nj == move.j) {
						visited[ni][nj] = true;
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				p = move;
			} else {
				check = false;
				break;
			}
		}
		if (check) {
			Point move = charToPoint(list[0]);
			boolean flag = false;
			for (int d = 0; d < 8; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				if (ni >= 0 && ni < 6 && nj >= 0 && nj < 6) {
					if (ni == move.i && nj == move.j) {
						visited[ni][nj] = true;
						flag = true;
						break;
					}
				}
			}
			if (!flag)
			check = false;
		}
		System.out.println(check ? "Valid" : "Invalid");
	}

	static Point charToPoint(char[] ch) {
		int i = ch[0] - 'A';
		int j = ch[1] - '1';
		return new Point(i, j);
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