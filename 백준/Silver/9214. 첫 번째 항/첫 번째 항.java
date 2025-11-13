import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		int cnt = 1;
		while(!(line = br.readLine()).equals("0")){
			while(true){
				String bf = before(line);
				if(line.equals(bf)) break;
				line = bf;
			}
			sb.append("Test ").append(cnt).append(": ").append(line).append("\n");
			cnt++;
		}
		System.out.println(sb.toString());
	}

	static String before(String st){
		String line = "";
		if(st.length()%2 == 1) return st;
		for(int i=0;i<st.length();i+=2){
			int cnt = Integer.parseInt(st.charAt(i)+"");
			int num = Integer.parseInt(st.charAt(i+1)+"");
			for(int j=0;j<cnt;j++){
				line += num;
			}
		}
		return line;
	}
}