import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int start = 0;
		int end = 1;
		int cnt = 0;
		int ans = 0;
		while(end < N){
			if(S.charAt(start) == 'A'){
				if(S.charAt(end) == 'A'){
					if(cnt == 1){
						ans++;
					}
					// System.out.println(S.substring(start, end+1));
					start = end;
					cnt = 0;
				}else if(S.charAt(end) == 'N'){
					cnt++;
				}
			}else{
				start++;
			}
			end++;
		}
		System.out.println(ans);
	}
}