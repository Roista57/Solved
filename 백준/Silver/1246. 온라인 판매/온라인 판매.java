import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[M];
		for(int i=0;i<M;i++){
			list[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(list);
		int max = 0;
		int cost = 0;
		int cnt = 1;
		for(int i=M-1;i>=0;i--){
			if(max <= list[i] * cnt){
				max = list[i] * cnt;
				cost = list[i];
			}
			if(cnt < N) cnt++;
		}
		System.out.println(cost+" "+max);
	}
}