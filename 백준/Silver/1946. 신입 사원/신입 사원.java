import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Score[] scores;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			int AMin = Integer.MAX_VALUE;
			int BMin = Integer.MAX_VALUE;
			scores = new Score[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int cnt = 0;
			Arrays.sort(scores);
			for (int i = 0; i < N; i++) {
				if (AMin > scores[i].A || BMin > scores[i].B) {
					if (!scores[i].select) {
						AMin = Integer.min(AMin, scores[i].A);
						BMin = Integer.min(BMin, scores[i].B);
						scores[i].select = true;
						cnt++;
					}

				}
			}
			System.out.println(cnt);
		}
	}

	static class Score implements Comparable<Score> {
		int A;
		int B;
		boolean select;

		public Score(int a, int b) {
			A = a;
			B = b;
		}

		@Override
		public String toString() {
			return "Score [A=" + A + ", B=" + B + "]";
		}

		@Override
		public int compareTo(Score o) {
			return Integer.compare(A, o.A);
		}
	}
}