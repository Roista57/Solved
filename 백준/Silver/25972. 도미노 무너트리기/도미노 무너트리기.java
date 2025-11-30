import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][2];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2){
				return o1[0] - o2[0];
			}
		});
		int ans = 0;
		int idx = 0;
		for(int i=0;i<N;i++){
			if(idx < list[i][0]){
				ans++;
			}
			idx = list[i][0] + list[i][1];
		}
		System.out.println(ans);
	}
}