import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int X = Integer.parseInt(br.readLine());
		int[][] list = new int[X + 1][2];
		int[][] temp = new int[3][2];
		
		for (int i = 2; i <= X; i++) {
			temp[0][0] = i - 1;
			temp[1][0] = i / 2;
			temp[2][0] = i / 3;
			
			temp[2][1] = i % 3 == 0 ? 1 + list[i / 3][0] : Integer.MAX_VALUE;
			temp[1][1] = i % 2 == 0 ? 1 + list[i / 2][0] : Integer.MAX_VALUE;
			temp[0][1] = 1 + list[i - 1][0];

			Arrays.sort(temp, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			list[i][0] = temp[0][1];
			list[i][1] = temp[0][0];
		}
		sb.append(list[X][0]+"\n");
		sb.append(X+" ");
		while(X != 1) {
			sb.append(list[X][1]+" ");
			if(list[X][1] == 1) break;
			X = list[X][1];
		}
		System.out.println(sb.toString());
	}
}