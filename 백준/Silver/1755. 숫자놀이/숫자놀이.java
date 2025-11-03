import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Dict> list = new ArrayList<Dict>();

		for(int i=N;i<=M;i++){
			list.add(new Dict(i, func1(i)));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i).num);
			if(i != 0 && i %10 == 9){
				sb.append("\n");
			}else{
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	static String func1(int num){
		String str = String.valueOf(num);
		String ans = "";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == '0'){
				ans += "zero";
			}else if(str.charAt(i) == '1'){
				ans += "one";
			}else if(str.charAt(i) == '2'){
				ans += "two";
			}else if(str.charAt(i) == '3'){
				ans += "three";
			}else if(str.charAt(i) == '4'){
				ans += "four";
			}else if(str.charAt(i) == '5'){
				ans += "five";
			}else if(str.charAt(i) == '6'){
				ans += "six";
			}else if(str.charAt(i) == '7'){
				ans += "seven";
			}else if(str.charAt(i) == '8'){
				ans += "eight";
			}else if(str.charAt(i) == '9'){
				ans += "nine";
			}
			ans += " ";
		}
		return ans.trim();
	}

}

class Dict implements Comparable<Dict>{
	int num;
	String str;
	public Dict(int num, String str){
		this.num = num;
		this.str = str;
	}

	@Override
	public int compareTo(Dict o){
		return str.compareTo(o.str);
	}
}