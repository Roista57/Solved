import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		int[] select = new int[N+1];
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

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(R);
		visited[R] = true;
		select[R] = ++cnt;

		while(!queue.isEmpty()){
			int num = queue.poll();
			for(int node : list.get(num)){
				if(!visited[node]){
					queue.add(node);
					visited[node] = true;
					select[node] = ++cnt;
				}
			}
		}

		for(int i=1;i<=N;i++){
			sb.append(select[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}