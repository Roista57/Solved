import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int[] list = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++){
				list[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);

			int min = 0;
			int max = list[n-1] - list[0];
			int ans = 0;

			while(min <= max){
				int mid = (min + max) / 2;
				if(select(list, n, s, mid)){
					ans = mid;
					min = mid + 1;
				}else{
					max = mid - 1;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static boolean select(int[] list, int n, int s, int d){
		int cnt = 1;
		int last = list[0];
		for(int i=1;i<n;i++){
			if(list[i] - last >= d){
				cnt++;
				last = list[i];
				if(cnt >= s) return true;;
			}
		}
		return false;
	}
}