import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long T = Long.parseLong(st.nextToken());
		long[] sharks = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			sharks[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(sharks);
		Stack<Long> stack = new Stack<Long>();
		Queue<Long> queue = new ArrayDeque<Long>();
		for(int i=0;i<N;i++){
			if(T > sharks[i]){
				stack.add(sharks[i]);
			}else{
				queue.add(sharks[i]);
			}
		}
		int cnt = 0;
		while(++cnt <= K){
			while(!queue.isEmpty() && T > queue.peek()){
				stack.add(queue.poll());
			}
			if(!stack.isEmpty()){
				T += stack.pop();
			}
		}
		System.out.println(T);
	}
}