import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> even = new PriorityQueue<Integer>();
		Queue<Integer> odd = new PriorityQueue<Integer>();
		for(int i=1;i<=N;i++){
			int num = Integer.parseInt(st.nextToken());
			if(num % 2 == 0){
				even.add(num);
			}else{
				odd.add(num);
			}
		}
		int size = 1;
		boolean flag = true;
		while(size <= N){
			if(size % 2 == 0){
				if(!even.isEmpty()){
					even.poll();
				}else{
					flag = false;
					break;
				}
			}else{
				if(!odd.isEmpty()){
					odd.poll();
				}else{
					flag = false;
					break;
				}
			}
			size++;
		}
		System.out.println(flag ? 1 : 0);
	}
}