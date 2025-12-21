import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0;i<Math.pow(2, N);i++){
			if(Integer.bitCount(i) == a){
				for(int j=0;j<Math.pow(2, N);j++){
					if(Integer.bitCount(j) == b){
						ans = Math.max(ans, i^j);
					}
				}
			}
		}
		System.out.println(ans);
	}
}