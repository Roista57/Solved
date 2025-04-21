import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		String[] list = new String[N];
		for (int i = 0; i < N; i++) {
			list[i] = st.nextToken();
		}

		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// o2를 o1 앞에 붙인 것과 o2를 o1 뒤에 붙인 것을 비교해서 내림차순으로 정렬
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str);
		}
		// BigInteger를 사용해서 00000 => 0으로 변환
		System.out.println(new BigInteger(sb.toString()));
	}
}