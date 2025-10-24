import java.util.*;
import java.io.*;

public class Main {
  static int[] di = {-1, 0, +1, 0};
  static int[] dj = {0, +1, 0, -1};
  static int N;
  static int M;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    int[] move = new int[P+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1;i<=P;i++){
      move[i] = Integer.parseInt(st.nextToken());
    }

    int[][] map = new int[N][M];
    boolean[][] visited = new boolean[N][M];
    ArrayList<Queue<Point>> list = new ArrayList<Queue<Point>>();
    for(int i=0;i<=P;i++){
      list.add(new ArrayDeque<Point>());
    }
    for(int i=0;i<N;i++){
      char[] line = br.readLine().toCharArray();
      for(int j=0;j<M;j++){
        if(line[j] == '.'){
          map[i][j] = 0;
        }else if(line[j] == '#'){
          map[i][j] = -1;
        }else{
          int p = line[j] - '0';
          map[i][j] = p;
          visited[i][j] = true;
          list.get(p).add(new Point(i, j, p, 0));
        }
      }
    }
    
    while(true){
      boolean flag = true;
      for(int i=1;i<=P;i++){
        if(!list.get(i).isEmpty()){
          flag = false;
          list.set(i, bfs(map, visited, move, list.get(i)));
        }
      }
      if(flag) break;
    }


    // for(int[] a : map){
    //   for(int b : a){
    //     System.out.print(b != -1 ? b+"" : "#");
    //   }
    //   System.out.println();
    // }
    // System.out.println("====================");

    

    int[] ans = new int[P+1];
    for(int i=0;i<N;i++){
      for(int j=0;j<M;j++){
        if(map[i][j] != -1){
          ans[map[i][j]]++;
        }
      }
    }

    for(int i=1;i<=P;i++){
      System.out.print(ans[i]+" ");
    }
  }

  static Queue<Point> bfs(int[][] map, boolean[][] visited, int[] move, Queue<Point> queue){
    Queue<Point> temp = new ArrayDeque<Point>();
    while(!queue.isEmpty()){
      Point p = queue.poll();

      for(int d=0;d<4;d++){
        int ni = p.i + di[d];
        int nj = p.j + dj[d];

        if(ni >= 0 && ni < N && nj >= 0 && nj < M){
          if(!visited[ni][nj] && map[ni][nj] == 0 && p.cnt < move[p.p]){
            queue.add(new Point(ni, nj, p.p, p.cnt+1));
            temp.add(new Point(ni, nj, p.p, 0));
            visited[ni][nj] = true;
            map[ni][nj] = p.p;
          }
        }
      }
    }
    return temp;
  }
}

class Point implements Comparable<Point>{
  int i, j, p, cnt;
  public Point(int i, int j, int p, int cnt){
    this.i = i;
    this.j = j;
    this.p = p;
    this.cnt = cnt;
  }
  @Override
  public int compareTo(Point o){
    return this.p - o.p;
  }
}