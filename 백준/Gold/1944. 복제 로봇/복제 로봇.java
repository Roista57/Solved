import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int[] di = {-1, 0, +1, 0};
    static int[] dj = {0, +1, 0, -1};

    static ArrayList<Edge>[] edges;
    static Point[] info;
    static boolean[] select;
    static Queue<Edge> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        info = new Point[M + 1];
        edges = new ArrayList[M + 1];
        select = new boolean[M + 1];
        ans = new PriorityQueue<>();

        for (int i = 0; i < M + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S' || map[i][j] == 'K') {
                    info[idx++] = new Point(i, j);
                }
            }
        }
        for (int i = 0; i <= M; i++) {
            bfs(info[i], i);
        }

        int sum = 0;
        ans.offer(new Edge(0, 0));
        while (!ans.isEmpty()) {
            Edge edge = ans.poll();

            if (!select[edge.to]) {
//                System.out.println(edge);
                select[edge.to] = true;
                sum += edge.weight;

                for (Edge next : edges[edge.to]) {
                    if (!select[next.to]) ans.offer(next);
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < M + 1; i++) {
            if (!select[i]) flag = false;
        }
        if (flag) {
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(Point start, int from) {
        char[][] temp = copyChar();
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.i][start.j] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                Point p = queue.poll();

                if (!start.equals(p) && temp[p.i][p.j] == 'K') {
//                    System.out.println(p);
                    for (int i = 0; i <= M; i++) {
                        if (info[i].equals(p)) {
                            edges[from].add(new Edge(i, time));
                            edges[i].add(new Edge(from, time));
                        }
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int ni = p.i + di[d];
                    int nj = p.j + dj[d];

                    if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj] && temp[ni][nj] != '1') {
                        queue.offer(new Point(ni, nj));
                        visited[ni][nj] = true;
                    }
                }
            }
            time++;
        }
    }

    static char[][] copyChar() {
        char[][] temp = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            if (i == p.i && j == p.j) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}