import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[N+1];
		int max = 0;
		int cnt = 0;
		for(int i=0;i<2*N;i++){
			int num = Integer.parseInt(st.nextToken());
			if(list[num] == 0){
				list[num]++;
				cnt++;
			}else if(list[num] == 1){
				list[num]++;
				cnt--;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}