import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static Delete[] delete;
	static int[] state;
	static boolean[] select;
	static boolean[] ans;
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		delete = new Delete[N + 1];
		state = new int[N + 1];
		select = new boolean[N + 1];
		ans = new boolean[N + 1];
		queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
			delete[i] = new Delete(i, new ArrayDeque<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[b].add(a);
			delete[a].list.offer(b);
//			Collections.sort(list[b]);
		}

		for (int i = 1; i < N + 1; i++) {
			state[i] = list[i].size();
			if (state[i] == 0) {
				queue.add(i);
			}
		}
		Queue<Integer> del = new ArrayDeque<>();
		while (!queue.isEmpty()) {
			int i = queue.poll();
			if (state[i] == 0 && !ans[i]) {
				ans[i] = true;
				System.out.print(i + " ");
				int size = delete[i].list.size();
				while (--size >= 0) {
					int num = delete[i].list.poll();
					state[num]--;
					if (state[num] == 0) {
						queue.add(num);
					} else {
						delete[i].list.offer(num);
					}
				}
			}
		}
		System.out.println();
	}

	static class Delete {
		int num;
		Queue<Integer> list;

		public Delete(int num, Queue<Integer> list) {
			this.num = num;
			this.list = list;
		}
	}
}