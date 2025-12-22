import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			char[] line = br.readLine().toCharArray();
			boolean flag = false;
			int idx = line.length-1;
			int target = 0;
			while(--idx >= 0){
				if(line[idx] < line[idx+1]){
					flag = true;
					target = idx;
					break;
				}
			}
			if(flag){
				idx = line.length;
				while(--idx > target){
					if(line[target] < line[idx]){
						break;
					}
				}
				char temp = line[target];
				line[target] = line[idx];
				line[idx] = temp;

				for(int i=0;i<=target;i++){
					sb.append(line[i]);
				}
				for(int i=line.length-1;i>target;i--){
					sb.append(line[i]);
				}
				sb.append("\n");
			}else{
				sb.append(String.valueOf(line)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}