import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int P = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		int idx = 0;
		while(idx < N){
			if(P >= 200) break;
			P += list[idx++];
		}
		System.out.println(idx);
	}
}