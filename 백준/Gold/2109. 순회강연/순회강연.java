import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Plan[] plans;
	static int[] days;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		int max = 0;
		int total = 0;
		plans = new Plan[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			max = Math.max(max, d);
			plans[i] = new Plan(p, d);
		}
		days = new int[max + 2];
		Arrays.sort(plans);

		for (int i = max; i > 0; i--) {
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (plans[j].day >= i && !plans[j].select) {
					days[i] = plans[j].cost + days[i + 1];
					plans[j].select = true;
					flag = true;
					break;
				}
			}
			if (!flag) {
				days[i] = days[i + 1];
			}
		}
		System.out.println(days[1]);
	}

	static class Plan implements Comparable<Plan> {
		int cost;
		int day;
		boolean select;

		public Plan(int cost, int day) {
			this.cost = cost;
			this.day = day;
		}

		@Override
		public int compareTo(Plan o) {
			if (o.cost > cost) {
				return 1;
			} else if (cost == o.cost) {
				return Integer.compare(o.day, day);
			} else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "Plan [cost=" + cost + ", day=" + day + "]";
		}
	}
}