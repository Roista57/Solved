import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String line = br.readLine();
			if(line.equals("END")){
				break;
			}
			sb.append(new StringBuilder(line).reverse()).append("\n");
		}
		System.out.println(sb.toString());
	}
}