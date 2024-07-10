import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        func(0, 0, N, N, N / 3);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null) {
                    sb.append(" ");
                } else {
                    sb.append(map[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void func(int si, int sj, int ei, int ej, int n) {
        if(map[si][sj] != null){
            return;
        }
        if (n == 0) {
            map[si][sj] = "*";
        } else {
            int cnt = 0;
            for (int i = si; i < ei; i += n) {
                for (int j = sj; j < ej; j += n) {
                    cnt++;
                    if (cnt != 5) {
                        func(i, j, i + n, j + n, n / 3);
                    }
                }
            }
        }
    }
}