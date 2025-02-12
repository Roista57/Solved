import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] list = new int[N];
		int[] temp = new int[N];
		
		
		for(int i=0;i<N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		temp[0] = list[0];
		int max = temp[0];
		
		for(int i=1;i<N;i++) {
			temp[i] = Math.max(temp[i-1]+list[i], list[i]);
			max = Math.max(max, temp[i]);
		}
		
		System.out.println(max);
	}
}