import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 100;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] paper = new int[MAX][MAX];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int w = y; w < y + 10; w++) {
					if (j < MAX && w < MAX) paper[j][w] = 1;
				}
			}
		}

		int sum = 0;
		for(int i=0;i<MAX;i++) {
			for(int j=0;j<MAX;j++) {
				if(paper[i][j] == 1) sum++;
			}
		}
		System.out.println(sum);

	}

}