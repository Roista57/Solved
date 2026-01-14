import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while(true){
			String line = br.readLine();
			if(line.equals("Was it a cat I saw?")) break;
			idx++;
			for(int i=0;i<line.length();i+=idx){
				sb.append(line.charAt(i));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}