import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Crane[] cranes;
	static int M;
	static ArrayList<Integer> box;
	static Queue<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		queue = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		cranes = new Crane[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cranes[i] = new Crane(Integer.parseInt(st.nextToken()));
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		box = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			box.add(num);
		}

		Collections.sort(box, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		Arrays.sort(cranes);

		if (cranes[0].num < box.get(0)) {
			System.out.println(-1);
		} else {
			int time = 0;
			while (!box.isEmpty()) {
				int idx = 0;

				for (int i = 0; i < N; i++) {
					if (box.isEmpty()) {
						break;
					}
					boolean flag = true;
					while (flag && idx != box.size()) {
						if (box.get(idx) <= cranes[i].num) {
							cranes[i].list.add(box.get(idx));
							box.remove(idx);
							flag = false;
						} else {
							idx++;
						}
					}
				}
				time++;
			}
			System.out.println(time);
		}

	}

	static class Crane implements Comparable<Crane> {
		int num;
		ArrayList<Integer> list;

		public Crane(int num) {
			this.num = num;
			list = new ArrayList<>();
		}

		@Override
		public int compareTo(Crane o) {
			return o.num - num;
		}

		@Override
		public String toString() {
			return num + "(" + list.toString() + ")";
		}
	}
}