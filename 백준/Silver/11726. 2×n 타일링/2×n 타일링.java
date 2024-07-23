import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] list = new long[1000];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        for (int i = 3; i < 1000; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 10007;

        }
        System.out.println(list[N - 1]);
    }
}