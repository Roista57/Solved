import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int cnt;
	static boolean[] select;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=N;i++){
			list.add(new ArrayList<Integer>());
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}

		int max = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i=1;i<=N;i++){
			select = new boolean[N+1];
			cnt = 0;
			func(i);
			if(max < cnt){
				max = cnt;
				ans = new ArrayList<Integer>();
				ans.add(i);
			}else if(max == cnt){
				ans.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int a : ans){
			sb.append(a+" ");
		}
		System.out.println(sb.toString());

	}
	static void func(int r){
		select[r] = true;
		cnt++;
		for(int node : list.get(r)){
			if(!select[node]){
				func(node);
			}
		}
	}
}