import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		boolean flag = true;
		int cnt = 0;
		for(int i=0;i<line.length();i++){
			if(line.charAt(i) == '.'){
				if(cnt % 2 != 0){
					flag = false;
					break;
				}
				for(int j=0;j<cnt/4;j++){
					sb.append("AAAA");
				}
				if(cnt%4 != 0) sb.append("BB");
				sb.append(".");
				cnt = 0;
			}else{
				cnt++;
			}
		}
		if(cnt != 0){
			if(cnt % 2 != 0){
				flag = false;
			}
			for(int j=0;j<cnt/4;j++){
				sb.append("AAAA");
			}
			if(cnt%4 != 0) sb.append("BB");
		}
		System.out.println(flag ? sb.toString() : -1);
	}
}