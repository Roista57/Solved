import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] students = new int[N];
		for(int i=0;i<N;i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for(int i=0;i<N;i++) {
			students[i] -= B;
			cnt++;
			if(students[i] > 0) {
				cnt += students[i]/C;
				if(students[i]%C != 0) cnt ++;
			}
		}
		System.out.println(cnt);
		
	}
}