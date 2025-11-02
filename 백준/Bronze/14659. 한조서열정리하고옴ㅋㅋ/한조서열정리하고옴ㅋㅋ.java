import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		int max = 0;
		int cnt = 0;
		for(int i=0;i<N;i++){
			int temp = Integer.parseInt(st.nextToken());
			if(max < temp){
				max = temp;
				ans = Math.max(ans, cnt);
				cnt = 0;
			}else{
				cnt++;
			}
		}
		ans = Math.max(ans, cnt);
		System.out.println(ans);
	}
}