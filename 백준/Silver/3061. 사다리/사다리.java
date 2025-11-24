import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				list[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N-1;j++){
					if(list[j] > list[j+1]){
						cnt++;
						int temp = list[j];
						list[j] = list[j+1];
						list[j+1] = temp;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}