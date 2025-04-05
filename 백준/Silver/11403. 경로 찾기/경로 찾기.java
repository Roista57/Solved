import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] temp;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		temp = new int[N][N];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			func(i, i);
		}

		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	static void func(int st, int idx) {
		for (int j = 0; j < N; j++) {
			if (temp[idx][j] == 1 && !visited[j]) {
				map[st][j] = 1;
				visited[j] = true;
				func(st, j);
			}
		}
	}
}