import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 보석의 개수
	static int K; // 가방의 개수
	static ArrayList<Integer> bags;
	static ArrayList<Gem> gems;

	// 가방 하나에 하나의 보석만 남을 수 있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long total = 0;

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bags = new ArrayList<>();
		gems = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			gems.add(new Gem(m, v));
		}

		for (int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(bags);
		Collections.sort(gems);

		// 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 내림차순으로 넣어보고 더 이상 못 넣을 때 값이 비싼 보석 챙기자
		int idx = 0;
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		for (int i = 0; i < K; i++) {
			while (idx < N && bags.get(i) >= gems.get(idx).M) {
				queue.add(gems.get(idx).V);
				idx++;
			}
			if (!queue.isEmpty())
				total += queue.poll();
		}
		System.out.println(total);
	}

	static class Gem implements Comparable<Gem> {
		int M; // 무게
		int V; // 가격

		public Gem(int m, int v) {
			super();
			M = m;
			V = v;
		}

		@Override
		public int compareTo(Gem o) {
			if (M > o.M) {
				return 1;
			} else if (M == o.M) {
				if (V < o.V) {
					return 1;
				} else if (V == o.V) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}
}