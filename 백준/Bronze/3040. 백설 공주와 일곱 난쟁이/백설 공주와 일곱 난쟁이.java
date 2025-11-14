import java.util.*;
import java.io.*;

public class Main {
	static int N = 9;
	static int[] list = new int[N];
	static boolean[] select = new boolean[N];
	static boolean flag = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<N;i++){
			list[i] = Integer.parseInt(br.readLine());
		}
		func(0, 0);
	}

	static void func(int idx, int cnt){
		if(cnt == 7 && !flag){
			int sum = 0;
			for(int i=0;i<N;i++){
				if(select[i]) sum += list[i];
			}
			if(sum == 100){
				for(int i=0;i<N;i++){
					if(select[i]) System.out.println(list[i]);
				}
				flag = true;
			}
			return;
		}
		if(idx == 9){
			return;
		}

		select[idx] = true;
		func(idx+1, cnt+1);

		select[idx] = false;
		func(idx+1, cnt);
	}
}