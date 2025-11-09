import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static String[] list;
	static boolean[] select;
	static int[] array;
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		list = new String[N];
		select = new boolean[N];
		array = new int[K];
		map = new HashMap<Integer, Integer>();
		for(int i=0;i<N;i++){
			list[i] = br.readLine();
		}
		func(0, 0);
		System.out.println(map.size());
	}

	static void func(int idx, int cnt){
		if(cnt == K){
			String line = "";
			for(int i=0;i<K;i++){
				line += list[array[i]];
			}
			map.put(Integer.parseInt(line), 1);
		}
		if(idx == K) return;
		for(int i=0;i<N;i++){
			if(!select[i]){
				select[i] = true;
				array[idx] = i;
				func(idx+1, cnt + 1);
				select[i] = false;
			}
		}
	}
}