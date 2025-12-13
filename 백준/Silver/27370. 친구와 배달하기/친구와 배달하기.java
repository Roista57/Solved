import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long Pa = Long.parseLong(st.nextToken());
			long Pb = Long.parseLong(st.nextToken());
			if(Pa > Pb){
				long temp = Pa;
				Pa = Pb;
				Pb = temp;
			}
			st = new StringTokenizer(br.readLine());
			long[] list = new long[N];
			long Ta = 0;
			long Tb = 0;
			for(int i=0;i<N;i++){
				list[i] = Long.parseLong(st.nextToken());
				Tb += Math.abs(Pb - list[i]) * 2;
			}
			Arrays.sort(list);
			long total = Ta + Tb;
			long dist = Math.abs(Tb - Ta);
			for(int i=0;i<N;i++){
				Ta += Math.abs(Pa - list[i]) * 2;
				Tb -= Math.abs(Pb - list[i]) * 2;
				if(total > Ta + Tb){
					total = Ta + Tb;
					dist = Math.abs(Tb - Ta);
				}else if(total == Ta + Tb){
					if(dist > Math.abs(Tb - Ta)){
						total = Ta + Tb;
						dist = Math.abs(Tb - Ta);
					}
				}
			}
			System.out.println(total+" "+dist);
		}
	}
}