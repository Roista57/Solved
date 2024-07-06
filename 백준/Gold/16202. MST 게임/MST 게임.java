import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static ArrayList<Edge>[] list;
    static LinkedList<int[]> edgeList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        edgeList = new LinkedList<>();


        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<Edge>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, i));
            list[to].add(new Edge(from, i));
            edgeList.add(new int[]{from, to});
        }

        Queue<Edge> queue = new PriorityQueue<>();
        for (int k = 0; k < K; k++) {
            if (k != 0) {
                int[] edges = edgeList.get(0);
                edgeList.remove(0);
                for (int d = 0; d < 2; d++) {
                    list[edges[d]].remove(0);
                }
            }
            visited = new boolean[N + 1];
            queue.offer(new Edge(1, 0));
            int total = 0;
            while (!queue.isEmpty()) {
                Edge e = queue.poll();

                if (visited[e.to]) continue;

                visited[e.to] = true;
                total += e.weight;
                for (Edge next : list[e.to]) {
                    if (!visited[next.to]) {
                        queue.offer(next);
                    }

                }
            }
            boolean flag = true;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) flag = false;
            }
            if (flag) {
                System.out.print(total + " ");
            } else {
                System.out.print(0 + " ");
            }

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
    }
}