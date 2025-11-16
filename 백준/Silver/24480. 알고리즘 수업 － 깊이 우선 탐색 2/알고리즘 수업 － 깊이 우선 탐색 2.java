import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;
	static int[] order;
	static int cnt = 1;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		order = new int[N+1];
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
		for(int i=1;i<=N;i++){
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		visited[R] = true;
		dfs(R);
		for(int i=1;i<=N;i++){
			System.out.println(order[i]);
		}
	}

	static void dfs(int node){
		order[node] = cnt++;
		for(int newNode : list.get(node)){
			if(!visited[newNode]){
				visited[newNode] = true;
				dfs(newNode);
			}
		}
	}
}