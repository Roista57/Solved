import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		int[][] map = new int[R][C];
		int i = 0;
		int j = 0;
		int rotate = 0;
		boolean flag = false;
		int[] ans = new int[2];
		if(K <= R*C){
			for(int t=1;t<=R*C;t++){
				map[i][j] = t;
				if(t == K){
					flag = true;
					ans[0] = j+1;
					ans[1] = i+1;
					break;
				}
				if(rotate == 0){
					if(i == R-1 || map[i+1][j] != 0){
						rotate = (rotate + 1) % 4;
						j++;
					}
					else i++;
				}else if(rotate == 1){
					if(j == C-1 || map[i][j+1] != 0){
						rotate = (rotate + 1) % 4;
						i--;
					}
					else j++;
				}else if(rotate == 2){
					if(i == 0 || map[i-1][j] != 0){
						rotate = (rotate + 1) % 4;
						j--;
					}
					else i--;
				}else if(rotate == 3){
					if(j == 0 || map[i][j-1] != 0){
						rotate = (rotate + 1) % 4;
						i++;
					}
					else j--;
				}
			}
		}
		if(flag){
			System.out.println(ans[0]+" "+ans[1]);
		}else{
			System.out.println(0);
		}
	}
}