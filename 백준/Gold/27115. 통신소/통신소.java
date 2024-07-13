import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[] di = {-1, 0, +1, 0};
    static int[] dj = {0, +1, 0, -1};
    static int[][] map;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int si = Integer.parseInt(st.nextToken()) - 1;
            int sj = Integer.parseInt(st.nextToken()) - 1;
            int len = Integer.parseInt(st.nextToken());
            queue.offer(new Point(si, sj, len));
            map[si][sj] = 2;
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = p.i + di[d];
                int nj = p.j + dj[d];

                if (ni < N && ni >= 0 && nj < M && nj >= 0 && map[ni][nj] != 1 && p.len > 0) {
                    queue.offer(new Point(ni, nj, p.len - 1));
                    map[ni][nj] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static class Point implements Comparable<Point>{
        int i;
        int j;
        int len;

        public Point(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }

        @Override
        public int compareTo(Point o) {
            return o.len - len;
        }
    }
}