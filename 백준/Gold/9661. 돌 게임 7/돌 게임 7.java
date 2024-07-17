import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long num = N % 5;
        if(num == 0) System.out.println("CY");
        else if(num == 1) System.out.println("SK");
        else if(num == 2) System.out.println("CY");
        else if(num == 3) System.out.println("SK");
        else if(num == 4)  System.out.println("SK");
    }
}