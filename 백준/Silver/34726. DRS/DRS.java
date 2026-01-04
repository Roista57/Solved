import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<String> ans = new ArrayList<String>();
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int sum = 0;
		Driver[] list = new Driver[N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			sum = (sum + p) % T;
			int position = (T - sum) % T;
			list[i] = new Driver(name, position);
		}

		Arrays.sort(list);
		for(int i=0;i<N;i++){
			int dist = (list[(i+1)%N].position - list[i].position + T )% T;
			if(dist > 0 && dist <= 1000){
				ans.add(list[i].name);
			}
		}
		if(ans.isEmpty()){
			sb.append("-1");
		}else{
			Collections.sort(ans);
			for(String str : ans){
				sb.append(str).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}

class Driver implements Comparable<Driver>{
	String name;
	int position;
	public Driver(String name, int position){
		this.name = name;
		this.position = position;
	}
	@Override
	public int compareTo(Driver o){
		return this.position - o.position;
	}
}