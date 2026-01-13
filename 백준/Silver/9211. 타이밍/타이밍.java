import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int o=0;o<T;o++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			double[] castle = new double[N];
			Edge[] edges = new Edge[I];
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N;i++){
				list.add(new ArrayList<Integer>());
			}

			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				castle[i] = Double.parseDouble(st.nextToken());
			}

			for(int i=0;i<I;i++){
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				double per = Double.parseDouble(st.nextToken());

				list.get(start).add(target);
				list.get(target).add(start);
				edges[i] = new Edge(start, target, per);
			}
			double[] out = new double[N];
			for(Edge e : edges) out[e.st] += e.per;
			for(int time=0;time<t;time++){
				double[] temp = new double[N];
				for(int i=0;i<N;i++){
					temp[i] = castle[i] * (1.0 - out[i]);
				}
				for(Edge e : edges){
					temp[e.ta] += castle[e.st] * e.per;
				}
				castle = temp;
			}
			double min = Double.MAX_VALUE;
			for(int i=0;i<N;i++){
				double sum = castle[i];
				for(int a : list.get(i)){
					sum += castle[a];
				}
				min = Math.min(min, sum);
			}
			sb.append(String.format("%.9f", min)).append("\n");
		}
		System.out.println(sb.toString());
	}
}

class Edge{
	int st;
	int ta;
	double per;

	public Edge(int st, int ta, double per){
		this.st = st;
		this.ta = ta;
		this.per = per;
	}
}