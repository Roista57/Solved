import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);

		int total = Integer.MAX_VALUE;
		int[] nums = new int[2];
		int num = 0;
		for (int i = 0; i < N; i++) {
//			System.out.println(list[i] + " >> ");
			num = -list[i];
			int search = Arrays.binarySearch(list, num);
			if (search < 0) {
				int test = -(search + 1);
//				System.out.println(test);
				if (test - 1 >= 0 && test - 1 < N && (test - 1) != i) {
//					System.out.print(list[test - 1] + " | ");
					if (total > Math.abs(list[i] + list[test - 1])) {
						total = Math.abs(list[i] + list[test - 1]);
						nums[0] = list[i];
						nums[1] = list[test - 1];
					}
				}
				if (test >= 0 && test < N && test != i) {
//					System.out.print(list[test] + " | ");
					if (total > Math.abs(list[i] + list[test])) {
						total = Math.abs(list[i] + list[test]);
						nums[0] = list[i];
						nums[1] = list[test];
					}
				}
				if (test + 1 >= 0 && test + 1 < N && (test + 1) != i) {
//					System.out.print(list[test + 1]);
					if (total > Math.abs(list[i] + list[test + 1])) {
						total = Math.abs(list[i] + list[test + 1]);
						nums[0] = list[i];
						nums[1] = list[test + 1];
					}
				}
//				System.out.println();
//				System.out.println("============");
			} else if (i != search) {
				total = Math.abs(list[i] + list[search]);
				nums[0] = list[i];
				nums[1] = list[search];
			}
		}
		Arrays.sort(nums);
		System.out.println(nums[0] + " " + nums[1]);
	}
}