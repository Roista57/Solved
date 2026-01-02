import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N+1];
		for(int i=1;i<=N;i++){
			list[i] = Integer.parseInt(br.readLine());
		}

		int[] piano = {0, 2, 3, 5, 7, 8, 10};
		boolean[] white = new boolean[12];
		for(int i=0;i<piano.length;i++){
			white[piano[i]] = true;
		}

		for(int i=0;i<piano.length;i++){
			boolean flag = true;
			int num = piano[i];
			for(int j=1;j<=N;j++){
				num = (num + list[j])%12;
				if(num < 0){
					num += 12;
				}
				if(!white[num]){
					flag = false;
					break;
				}
			}
			if(flag){
				sb.append(convert(piano[i])).append(" ").append(convert(num)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static String convert(int num){
		switch(num){
			case 0 : return "A";
			case 2 : return "B";
			case 3 : return "C";
			case 5 : return "D";
			case 7 : return "E";
			case 8 : return "F";
			default : return "G";
		}
	}
}