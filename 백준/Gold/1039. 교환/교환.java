import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int size = (int) Math.log10(N) + 1;

		Set<Integer> set = new HashSet<Integer>();
		set.add(N);

		Set<Integer> tempSet;
		for (int k = 0; k < K; k++) {
			tempSet = new HashSet<Integer>();
			for (int number : set) {
				for (int i = 0; i < size; i++) {
					for (int j = i + 1; j < size; j++) {
						char[] ch = String.valueOf(number).toCharArray();
						char temp = ch[i];
						ch[i] = ch[j];
						ch[j] = temp;
						int num = Integer.parseInt(String.valueOf(ch));
						if ((int) Math.pow(10, size - 1) <= num) {
							tempSet.add(num);
						}
					}
				}
			}
			set = tempSet;
		}

		int max = -1;
		for (int a : set) {
			max = Math.max(max, a);
		}
		System.out.println(max);
	}
}