import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double size = (250 * 250) / 2;
		double ansX = 0;
		double ansY = 0;

		if(x + y == 250){
			if(x <= 125){
				ansX = 250 - size / y;
				ansY = 0;
			}else{
				ansX = 0;
				ansY = 250 - size / x;
			}
		}else if(x == 0){
			if(y <= 125){
				ansX = size / (250 - y);
				ansY = 250 - ansX;
			}else{
				ansX = size / y;
				ansY = 0;
			}
		}else if(y == 0){
			if(x <= 125){
				ansY = size / (250 - x);
				ansX = 250 - ansY;
			}else{
				ansX = 0;
				ansY = size / x;
			}
		}
		System.out.println(String.format("%.2f %.2f", ansX, ansY));
	}
}