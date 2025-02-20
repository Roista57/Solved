import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] list = new int[n][4];
		for (int i = 0; i < n; i++) {
			list[i][0] = i;
			list[i][1] = sc.nextInt();
			list[i][2] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			int x = list[i][1];
			int y = list[i][2];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (x < list[j][1] && y < list[j][2]) {
					cnt++;
				}
			}
			list[i][3] = ++cnt;
		}

		for (int[] a : list) {
			System.out.print(a[3] + " ");
		}

	}
}