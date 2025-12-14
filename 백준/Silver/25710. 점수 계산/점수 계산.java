import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[1000];
		for(int i=0;i<N;i++){
			int num = Integer.parseInt(st.nextToken());
			list[num]++;
		}
		int max = 0;
		for(int i=1;i<list.length;i++){
			if(list[i] == 0) continue;
			for(int j=i;j<list.length;j++){
				if(list[j] == 0) continue;
				if(i == j && list[i] <= 1) continue;
				int num = calc(i, j);
				max = Math.max(max, num);
			}
		}
		System.out.println(max);
	}
	static int calc(int a, int b){
		int num = a * b;
		int ans = 0;
		while(num != 0){
			ans += num % 10;
			num /= 10;
		}
		return ans;
	}
}