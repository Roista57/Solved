import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] pointers = new int[M+1];
		boolean[] select = new boolean[M+1];
		for(int i=1;i<=M;i++){
			pointers[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<Q;i++){
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			if(line.equals("assign")){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pointers[x] = pointers[y];
			}else if(line.equals("swap")){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int temp = pointers[x];
				pointers[x] = pointers[y];
				pointers[y] = temp;
			}else{
				int x = Integer.parseInt(st.nextToken());
				pointers[x] = 0;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=M;i++){
			if(pointers[i] != 0 && !select[pointers[i]]){
				select[pointers[i]] = true;
				list.add(pointers[i]);
			}
		}
		Collections.sort(list);
		for(int a : list){
			sb.append(a).append("\n");
		}
		System.out.println(list.size());
		if(list.size() > 0){
			System.out.println(sb.toString());
		}
	}
}