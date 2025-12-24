import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] list = new int[N][2];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list, (o1, o2) -> {
			if(o1[0]  == o2[0]){
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int ans = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			if(list[i][1] < min){
				min = list[i][1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}