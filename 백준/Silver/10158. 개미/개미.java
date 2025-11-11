import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());

		P = W - Math.abs(W - (P + T) % (W * 2));
		Q = H - Math.abs(H - (Q + T) % (H * 2));
		System.out.println(P+" "+Q);
	}
}