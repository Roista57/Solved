import java.io.*;
import java.util.*;

public class Main {
	static int cnt;
	static int K;
	static boolean flag;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		flag = false;
		ans = new int[2];

		int[] list = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			list[i] = Integer.parseInt(st.nextToken());
		}

		select(list, 0, N-1, Q);
		if(flag){
			System.out.println(ans[0]+" "+ans[1]);
		}else{
			System.out.println(-1);
		}


	}
	static int select(int[] A, int p, int r, int q){
		if(p == r) return A[p];
		int t = partition(A, p, r);
		int k = t - p + 1;
		if(q < k){
			return select(A, p, t-1, q);
		}else if(q == k){
			return A[t];
		}else{
			return select(A, t+1, r, q-k);
		}
	}

	static int partition(int[] A, int p, int r){
		int x = A[r];
		int i = p - 1;
		for(int j=p;j<=r-1;j++){
			if(A[j] <= x) swap(A, ++i, j);
		}
		if(i + 1 != r) swap(A, i+1, r);
		return i+1;
	}

	static void swap(int[] A, int x, int y){
		cnt++;
		if(cnt == K){
			flag = true;
			if(A[x] < A[y]){
				ans[0] = A[x];
				ans[1] = A[y];
			}else{
				ans[0] = A[y];
				ans[1] = A[x];
			}
		}
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
}