import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		ArrayList<Check> list = new ArrayList<Check>();
		int[] checkList = new int[a+b+c+1];
		Arrays.fill(checkList, 2);
		for(int n=0;n<N;n++){
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list.add(new Check(i, j, k, r));
		}
		Collections.sort(list);
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(Check ch : list){
			if(ch.r == 1){
				checkList[ch.i] = 1;
				checkList[ch.j] = 1;
				checkList[ch.k] = 1;
			}else{
				if(checkList[ch.i] != 1){
					queue.add(ch.i);
				}
				if(checkList[ch.j] != 1){
					queue.add(ch.j);
				}
				if(checkList[ch.k] != 1){
					queue.add(ch.k);
				}
				if(queue.size() == 1){
					checkList[queue.poll()] = 0;
				}else{
					while(!queue.isEmpty()){
						queue.poll();
					}
				}
			}
		}
		for(int i=1;i<=a+b+c;i++){
			sb.append(checkList[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}

class Check implements Comparable<Check>{
	int i, j, k, r;
	public Check(int i, int j, int k, int r){
		this.i = i;
		this.j = j;
		this.k = k;
		this.r = r;
	}

	@Override
	public int compareTo(Check o){
		return o.r - r;
	}

	@Override
	public String toString(){
		return i+", "+j+", "+k+", "+r;
	}
}