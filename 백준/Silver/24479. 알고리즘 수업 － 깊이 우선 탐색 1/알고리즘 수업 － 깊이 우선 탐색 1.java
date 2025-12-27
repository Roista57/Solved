import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] select;
	static int time;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		select = new int[N+1];
		time = 0;

		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=N;i++){
			list.add(new ArrayList<Integer>());
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}

		for(int i=0;i<=N;i++){
			Collections.sort(list.get(i));
		}
		dfs(R);
		for(int i=1;i<=N;i++){
			sb.append(select[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

	static void dfs(int r){
		visited[r] = true;
		select[r] = ++time;
		for(int node : list.get(r)){
			if(!visited[node]){
				dfs(node);
			}
		}
	}
}