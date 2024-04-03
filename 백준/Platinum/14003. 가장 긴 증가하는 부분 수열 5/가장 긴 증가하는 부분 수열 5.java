import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int[] list = new int[N];
		Point[] answer = new Point[N];
		int idx = 0;

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			int search = Arrays.binarySearch(answer, 0, idx, new Point(list[i], null)) + 1;
			if (search <= 0) {
				int s = Math.abs(search);
				if (idx <= s) {
					if (idx == 0) {
						answer[idx++] = new Point(list[i], null);
					} else {
						answer[idx] = new Point(list[i], answer[idx - 1]);
						idx++;
					}
				} else {
					if (s == 0) {
						answer[s] = new Point(list[i], null);
					} else {
						answer[s] = new Point(list[i], answer[s - 1]);
					}
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			int search = Arrays.binarySearch(answer, 0, idx, new Point(list[i], null)) + 1;
//			if (search <= 0) {
//				int s = Math.abs(search);
//				if (idx <= s) {
//					if (idx == 0) {
//						answer[idx++] = new Point(list[i], null);
//					} else {
//						answer[idx] = new Point(list[i], answer[idx - 1]);
//						idx++;
//					}
//				} else {
//					if (s == 0) {
//						answer[s] = new Point(list[i], null);
//					} else {
//						answer[s] = new Point(list[i], answer[s - 1]);
//					}
//				}
//			}
//		}
		System.out.println(idx);
		print(answer[idx - 1]);
		System.out.println(sb.toString());
	}

	static void print(Point point) {
		if (point.next != null) {
			print(point.next);
//			System.out.print(point.number + " ");
			sb.append(point.number + " ");
		} else {
//			System.out.print(point.number + " ");
			sb.append(point.number + " ");
		}

	}

	static class Point implements Comparable<Point> {
		int number;
		Point next;

		public Point(int number, Point next) {
			this.number = number;
			this.next = next;
		}

		@Override
		public String toString() {
			if (next == null) {
				return number + "->null";
			} else {
				return number + "->" + next.number;
			}

		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(number, o.number);
		}

	}
}