import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		if(N <= 9){
			ans = 1;
		}else if(N%2 == 0){
			int temp1 = 0;
			int temp2 = 0;
			if(N%18 != 0){
				temp1 = (N/18 + 1)*2;
			}else{
				temp1 = (N/18) * 2;
			}
			if((N-8)%18 != 0){
				temp2 = ((N-8)/18 + 1) * 2 + 1;
			}else{
				temp2 = (N-8)/18 * 2 + 1;
			}
			ans = Math.min(temp1, temp2);
		}else{
			if((N-9)%18 != 0){
				ans = ((N-9)/18 + 1) * 2 + 1;
			}else{
				ans = (N-9)/18 * 2 + 1;
			}
		}
		System.out.println(ans);

	}
}