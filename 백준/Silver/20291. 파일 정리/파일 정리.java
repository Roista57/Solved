import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for(int i=0;i<N;i++){
			String[] line = br.readLine().split("\\.");
			String key = line[1];
			if(map.containsKey(key)){
				map.put(line[1], map.get(key) + 1);
			}else{
				map.put(key, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Integer> entry : map.entrySet()){
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		System.out.println(sb.toString());
	}
}