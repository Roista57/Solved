import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] burgers = new int[3];
		int[] drinks = new int[2];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			burgers[i] = sc.nextInt();
		}
		for (int i = 0; i < 2; i++) {
			drinks[i] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				min = Math.min(min, burgers[i] + drinks[j] - 50);
			}
		}
		System.out.println(min);
	}
}