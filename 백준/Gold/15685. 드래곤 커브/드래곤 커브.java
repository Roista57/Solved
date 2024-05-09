import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static Node[] nodes;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(x, y, d, g);
		}

		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<>();
			ArrayList<Integer> list = new ArrayList<>();
			ArrayList<Point> list2 = new ArrayList<>();
			stack.push(nodes[i].d);
			list.add(stack.peek());
			for (int j = 0; j < nodes[i].g; j++) {
				while (!stack.isEmpty()) {
					int p = (stack.pop() + 1) % 4;
					list.add(p);
				}
				for (int k = 0; k < list.size(); k++) {
					stack.push(list.get(k));
				}
			}
			Point p = new Point(nodes[i].i, nodes[i].j);
			if (p.i < 101 && p.j < 101) {
				map[p.i][p.j] = 1;
			}
			list2.add(p);
			for (int j = 0; j < list.size(); j++) {
				p = new Point(p.i + di[list.get(j)], p.j + dj[list.get(j)]);
				if (p.i < 101 && p.j < 101) {
					map[p.i][p.j] = 1;
				}
				list2.add(p);
			}
		}
		int total = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				int cnt = 0;
				if (map[i][j] == 1) {
					for (int k = 0; k < 2; k++) {
						for (int w = 0; w < 2; w++) {
							if (i + k < 101 && j + w < 101 && map[i + k][j + w] == 1) {
								cnt++;
							}
						}
					}
					if (cnt == 4)
						total++;
				}
			}
		}
		System.out.println(total);

	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}

	}

	static class Node {
		int i;
		int j;
		int d;
		int g;

		public Node(int i, int j, int d, int g) {
			this.i = i;
			this.j = j;
			this.d = d;
			this.g = g;
		}
	}
}