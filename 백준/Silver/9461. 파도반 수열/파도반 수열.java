import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int max = 101;
        long[] list = new long[max];
        list[1] = 1;
        list[2] = 1;
        for (int i = 3; i < max; i++) {
            list[i] = list[i - 2] + list[i - 3];
        }
        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(list[N]);
        }
    }
}