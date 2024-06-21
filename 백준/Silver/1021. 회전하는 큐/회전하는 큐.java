import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();

		Queue<Integer> ans = new ArrayDeque<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			ans.offer(Integer.parseInt(st.nextToken()));
		}

//		10 3
//		2 9 5

//		System.out.println(list.size());
		int cnt = 0;
		int total = 0;
		while (cnt < M) {
			int size = list.size();
			temp = new ArrayList<>();
			int c = 0;
//			System.out.println(list.toString());
//			System.out.println("number: " + ans.peek());
			int idx = list.indexOf(ans.poll()) + 1;
			int num = 0;
//			System.out.println("idx: " + idx);

			if (idx > (size / 2) + 1) {
				num = (size - idx) + 1;
				total += num;
			} else {
				num = idx - 1;
				total += num;
			}
//			System.out.println("size: " + size);
//			System.out.println("num: " + num);
			while (c < size - 1) {
				if (idx >= size) {
					idx = 0;
				}
				temp.add(list.get(idx));
				idx++;
				c++;
			}
			list = (ArrayList<Integer>) temp.clone();
			cnt++;
//			System.out.println(temp.toString());
//			System.out.println(num);
//			System.out.println("total: " + total);
//			System.out.println("----------------------");
		}

		System.out.println(total);

	}
}