import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int notCute = 0;
		int cute = 0;
		for (int i = 0; i < N; i++) {
			int vote = Integer.parseInt(br.readLine());
			if (vote == 0) {
				notCute++;
			} else {
				cute++;
			}
		}
		System.out.println(notCute > cute ? "Junhee is not cute!" : "Junhee is cute!");
	}
}