import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Prize> queue = new PriorityQueue<Prize>();
			int ans = 0;
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				int K = Integer.parseInt(st.nextToken());
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int k=0;k<K;k++){
					list.add(Integer.parseInt(st.nextToken()));
				}
				int money = Integer.parseInt(st.nextToken());
				queue.add(new Prize(list, money));
			}

			st = new StringTokenizer(br.readLine());
			int[] stickers = new int[M+1];
			for(int i=1;i<=M;i++){
				stickers[i] = Integer.parseInt(st.nextToken());
			}

			while(!queue.isEmpty()){
				Prize pz = queue.poll();

				int min = Integer.MAX_VALUE;
				for(int a : pz.list){
					min = Math.min(min, stickers[a]);
				}
				ans += pz.money * min;
				for(int a : pz.list){
					stickers[a] -= min;
				}
			}
			System.out.println(ans);
		}
	}
}

class Prize implements Comparable<Prize>{
	ArrayList<Integer> list;
	int money;
	public Prize(ArrayList<Integer> list, int money){
		this.list = list;
		this.money = money;
	}

	@Override
	public int compareTo(Prize o){
		return o.money - this.money;
	}
}