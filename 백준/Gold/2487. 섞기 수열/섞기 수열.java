import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1;i<=N;i++){
			list[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[N+1];
		ArrayList<Integer> len = new ArrayList<Integer>();
		for(int i=1;i<=N;i++){
			int cnt = 0;
			if(!visited[i]){
				int num = i;
				while(!visited[num]){
					visited[num] = true;
					num = list[num];
					cnt++;
				}
				len.add(cnt);
			}
		}

		int ans = 1;
		for(int a : len){
			ans = lcm(ans, a);
		}
		System.out.println(ans);

	}
	static int lcm(int a, int b){
		return a / gcd(a, b) * b;
	}

	static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}