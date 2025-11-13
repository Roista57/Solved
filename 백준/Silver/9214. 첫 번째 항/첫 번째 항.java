import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int cnt = 1;
		while(!(line = br.readLine()).equals("0")){
			while(true){
				String bf = before(line);
				if(line.equals(bf)) break;
				line = bf;
			}
			System.out.println("Test "+cnt+": "+line);
			cnt++;
		}
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

	static String after(String st){
		String line = "";
		int cnt = 0;
		char ch = st.charAt(0);
		for(int i=0;i<st.length();i++){
			if(ch == st.charAt(i)){
				cnt++;
			}else{
				line += cnt+""+ch+"";
				cnt = 1;
				ch = st.charAt(i);
			}
		}
		line += cnt+""+ch+"";
		return line;
	}
}