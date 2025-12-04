import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++){
			int[] list = new int[26];
			char[] line = br.readLine().toCharArray();
			for(char a : line){
				if(a >= 'a' && a <= 'z'){
					list[a - 'a']++;
				}else if(a >= 'A' && a <= 'Z'){
					list[a - 'A']++;
				}
			}
			int min = Integer.MAX_VALUE;
			for(int j=0;j<list.length;j++){
				min = Math.min(min, list[j]);
			}
			sb.append("Case ").append(i).append(": ");
			if(min == 0){
				sb.append("Not a pangram");
			}else if(min == 1){
				sb.append("Pangram!");
			}else if(min == 2){
				sb.append("Double pangram!!");
			}else{
				sb.append("Triple pangram!!!");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}