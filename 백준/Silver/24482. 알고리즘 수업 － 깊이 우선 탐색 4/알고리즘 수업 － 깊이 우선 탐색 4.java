import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] ans;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1];
		ans = new int[N+1];
		Arrays.fill(ans, -1);
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
			Collections.sort(list.get(i), Collections.reverseOrder());
		}

		dfs(R, -1);
		for(int i=1;i<=N;i++){
			System.out.println(ans[i]);
		}
	}
	static void dfs(int node, int depth){
		visited[node] = true;
		depth++;
		ans[node] = depth;
		for(int nextNode : list.get(node)){
			if(!visited[nextNode]) dfs(nextNode, depth);
		}
	}
}