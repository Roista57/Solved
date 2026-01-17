import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=1;i<=N;i++){
			queue.add(i);
		}
		long t = 1;
		while(queue.size() > 1){
			long num = t * t * t;
			int size = queue.size();
			num = num % size;
			if(num == 0) num = size;
			for(long i=1;i<=num-1;i++){
				queue.add(queue.poll());
			}
			queue.poll();
			t++;
		}
		System.out.println(queue.peek());
	}
}