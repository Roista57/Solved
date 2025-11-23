import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String[] line = br.readLine().split(",");
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for(String st : line){
				String[] temp = st.split(":");
				map.put(temp[0], Integer.parseInt(temp[1]));
			}
			line = br.readLine().split("\\|");
			int min = Integer.MAX_VALUE;
			for(String st : line){
				int max = 0;
				for(String str : st.split("&")){
					max = Math.max(max, map.get(str));
				}
				min = Math.min(min, max);
			}
			System.out.println(min);
		}
	}
}