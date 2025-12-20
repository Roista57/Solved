import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] list = new int[2][2];
		int idx = 0;

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				int num = Integer.parseInt(st.nextToken());
				if(num == 1){
					list[idx][0] = i;
					list[idx][1] = j;
					idx++;
				}
			}
		}
		int ans = Math.abs(list[0][0] - list[1][0]) + Math.abs(list[0][1] - list[1][1]);
		System.out.println(ans);
	}
}