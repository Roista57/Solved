import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static final int N = 10;
	static int[][][] map;

	static int[] di = { 0, -1, 0, +1, 0 };
	static int[] dj = { 0, 0, +1, 0, -1 };

	static int M;
	static int A;

	static User userA;
	static User userB;
	static int total;

	static int[][] move;
	static int[][] bc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			map = new int[A][N][N];
			move = new int[2][M + 1];
			bc = new int[A][4]; // j, i, c, p
			total = 0;

			userA = new User(0, 0, new ArrayList<>());
			userB = new User(N - 1, N - 1, new ArrayList<>());

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < M + 1; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
				bfs(i, bc[i]);
			}

			for (int k = 0; k < M + 1; k++) {
				int nowi = userA.i + di[move[0][k]];
				int nowj = userA.j + dj[move[0][k]];

				if (nowi >= 0 && nowi < N && nowj >= 0 && nowj < N) {
					userA.i = userA.i + di[move[0][k]];
					userA.j = userA.j + dj[move[0][k]];
				}
				userA.list = new ArrayList<>();

				nowi = userB.i + di[move[1][k]];
				nowj = userB.j + dj[move[1][k]];

				if (nowi >= 0 && nowi < N && nowj >= 0 && nowj < N) {
					userB.i = userB.i + di[move[1][k]];
					userB.j = userB.j + dj[move[1][k]];
				}
				userB.list = new ArrayList<>();
				
				userA.list.add(new BC(-1, 0));
				userB.list.add(new BC(-1, 0));
				
				for (int i = 0; i < A; i++) {
					userA.list.add(new BC(i, map[i][userA.i][userA.j]));
				}
				for (int i = 0; i < A; i++) {
					userB.list.add(new BC(i, map[i][userB.i][userB.j]));
				}

				Collections.sort(userA.list);
				Collections.sort(userB.list);

				if (userA.list.get(0).num == userB.list.get(0).num) {
					int temp1 = userA.list.get(0).power + userB.list.get(1).power;
					int temp2 = userA.list.get(1).power + userB.list.get(0).power;
					if (temp1 > temp2)
						userB.list.remove(0);
					else
						userA.list.remove(0);
				}
				total += userA.list.get(0).power + userB.list.get(0).power;
			}
			System.out.println("#" + tc + " " + total);
		}
	}

	static void bfs(int num, int[] charger) {
		boolean[][] visited = new boolean[N][N];
		Point start = new Point(charger[1] - 1, charger[0] - 1);
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);

		visited[start.i][start.j] = true;
		map[num][start.i][start.j] = charger[3];
		int time = 0;

		while (!queue.isEmpty()) {
			if (time == charger[2])
				break;
			int size = queue.size();

			while (--size >= 0) {
				Point p = queue.poll();

				for (int d = 1; d <= 4; d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
						queue.offer(new Point(ni, nj));
						map[num][ni][nj] = charger[3];
						visited[ni][nj] = true;
					}
				}
			}
			time++;
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

	static class User {
		int i;
		int j;
		ArrayList<BC> list;

		public User(int i, int j, ArrayList<BC> list) {
			this.i = i;
			this.j = j;
			this.list = list;
		}

		@Override
		public String toString() {
			return "User [i=" + i + ", j=" + j + "]";
		}
	}

	static class BC implements Comparable<BC> {
		int num;
		int power;

		public BC(int num, int power) {
			this.num = num;
			this.power = power;
		}

		@Override
		public int compareTo(BC o) {
			if (power < o.power) {
				return 1;
			} else if (power == o.power) {
				return 0;
			} else {
				return -1;
			}
		}
	}
}