import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		int cntZero = 0;
		int cntOne = 0;

		char ch = line[0];
		int idx = 1;
		while(idx < line.length){
			if(ch != line[idx]){
				if(ch == '0'){
					cntZero++;
				}else{
					cntOne++;
				}
				ch = line[idx];
			}
			idx++;
		}
		if(ch == '0'){
			cntZero++;
		}else{
			cntOne++;
		}
		System.out.println(Math.min(cntZero, cntOne));
	}
}