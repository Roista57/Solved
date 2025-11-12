import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		if(X > Y){
			for(int i=0;i<X-Y;i++){
				System.out.print(1);
			}
			for(int i=0;i<Y;i++){
				System.out.print(2);
			}
		}else{
			for(int i=0;i<Y-X;i++){
				System.out.print(1);
			}
			for(int i=0;i<X;i++){
				System.out.print(2);
			}
		}
	}
}