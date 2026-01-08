import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		for(int i=0;i<line.length();i++){
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}