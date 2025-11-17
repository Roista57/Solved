import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] str = line.split(" ");
		StringBuilder sb = new StringBuilder();
		Queue<String> queue = new ArrayDeque<String>();
		for(int i=0;i<str.length;i++){
			if(!str[i].equals("")){
				String token = "";
				for(int j=0;j<str[i].length();j++){
					if(str[i].charAt(j) == '<' || str[i].charAt(j) == '>' || str[i].charAt(j) == '(' || str[i].charAt(j) == ')'){
						if(token.length() != 0){
							queue.add(token);
							token = "";
						}
						queue.add(str[i].charAt(j)+"");
					}else if(str[i].charAt(j) == '&' || str[i].charAt(j) == '|'){
						if(token.length() != 0){
							queue.add(token);
							token = "";
						}
						queue.add(str[i].charAt(j)+""+str[i].charAt(++j)+"");
					}else{
						token += str[i].charAt(j)+"";
					}
				}
				if(token.length() != 0){
					queue.add(token);
				}
			}
		}

		while(!queue.isEmpty()){
			sb.append(queue.poll()).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}