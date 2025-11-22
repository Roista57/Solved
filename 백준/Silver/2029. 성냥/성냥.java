import java.util.*;
import java.io.*;

public class Main {
	static int N = 10;
	static int[][] list = new int[][] {
		{1, 1}, {1, 3}, {1, 5}, // 8
		{3, 1},{3, 3},{3, 5},
		{5, 1},{5, 3},{5, 5},
		{2, 2},{2, 4},{4, 2},{4, 4}, // 16
		{3, 3}, // 24
	};
	static int[][] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[10][];
		board = new int[7][7];
		for(int i=0;i<N;i++){
			map[i] = br.readLine().toCharArray();
		}

		int cnt = 0;
		int total = 0;


		for(int i=0, x=0;i<N;i+=3,x+=2){
			Arrays.fill(board[x], 1);
			for(int j=1, y=1;j<N;j+=3, y+=2){
				if(map[i][j] != '-'){
					board[x][y] = 0;
					cnt++;
				}
			}
		}

		for(int j=0, y=0;j<N;j+=3,y+=2){
			for(int i=1, x=1;i<N;i+=3, x+=2){
				if(map[i][j] == '|'){
					board[x][y] = 1;
				}else{
					cnt++;
				}
			}
		}
		for(int i=0;i<9;i++){
			if(count(list[i][0], list[i][1], 1) == 8){
				total++;
			}
		}
		for(int i=9;i<13;i++){
			if(count(list[i][0], list[i][1], 2) == 16){
				total++;
			}
		}
		for(int i=13;i<=13;i++){
			if(count(list[i][0], list[i][1], 3) == 24){
				total++;
			}
		}
		System.out.println(cnt+" "+total);
	}

	static int count(int x, int y, int size){
		int cnt = 0;
		for(int j=y-size;j<=y+size;j++){
			if(board[x-size][j] == 1) cnt++;
		}
		for(int j=y-size;j<=y+size;j++){
			if(board[x+size][j] == 1) cnt++;
		}
		for(int i=x-size;i<=x+size;i++){
			if(board[i][y-size] == 1) cnt++;
		}
		for(int i=x-size;i<=x+size;i++){
			if(board[i][y+size] == 1) cnt++;
		}
		return cnt - 4;
	}
}