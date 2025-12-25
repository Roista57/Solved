import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			char[] line = br.readLine().toCharArray();
			int[] cnt = new int[26];
			int idx = 0;
			boolean flag = true;
			while(idx < line.length){
				int num = line[idx] - 'A';
				if(++cnt[num] % 3 == 0){
					if(idx+1 >= line.length){
						flag = false;
						break;
					}else if(line[idx] != line[idx+1]){
						flag = false;
						break;
					}else{
						idx++;
					}
				}
				idx++;
			}
			if(flag) sb.append("OK").append("\n");
			else sb.append("FAKE").append("\n");
		}
		System.out.println(sb.toString());
	}
}