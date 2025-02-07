import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int[] heights;
	static boolean[] selected;
	static final int MAX = 9;
	static boolean find = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heights = new int[MAX];
		selected = new boolean[MAX];
		for (int i = 0; i < MAX; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}
		func(0, 0);
	}

	public static void func(int idx, int cnt) {
		if(find) return;
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < MAX; i++) {
				if (selected[i])
					sum += heights[i];
			}
			if (sum == 100) {
				find = true;
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < MAX; i++) {
					if (selected[i])
						list.add(heights[i]);
				}
				Collections.sort(list);
				for (int a : list)
					System.out.println(a);
				return;
			}
		}
		if (idx == MAX)
			return;
		selected[idx] = true;
		func(idx + 1, cnt + 1);
		selected[idx] = false;
		func(idx + 1, cnt);
	}
}