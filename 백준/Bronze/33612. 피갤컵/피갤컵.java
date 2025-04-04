import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int y = 2024;
		int m = 1 + 7 * N;
        y = 2024 + m / 12;
        if(m%12 == 0){
            m = 12;
            y--;
        }else{
            m = m % 12;
        }
		System.out.println(y +" "+ m);
	}
}