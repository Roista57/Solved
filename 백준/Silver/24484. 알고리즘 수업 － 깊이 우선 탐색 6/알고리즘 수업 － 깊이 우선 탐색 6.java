import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int T;
	static long[] time;
	static long[] depth;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		T = 1;
		visited = new boolean[N+1];
		time = new long[N+1];
		depth = new long[N+1];
		Arrays.fill(depth, -1L);
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++){
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		for(int i=1;i<N+1;i++){
			Collections.sort(list.get(i), Collections.reverseOrder());
		}

		dfs(R, 0L);
		long ans = 0;
		for(int i=1;i<=N;i++){
			ans += depth[i] * time[i];
		}
		System.out.println(ans);
	}

	static void dfs(int n, long d){
		visited[n] = true;
		depth[n] = d;
		time[n] = T++;
		for(int num : list.get(n)){
			if(!visited[num]) dfs(num, d+1);
		}
	}
}