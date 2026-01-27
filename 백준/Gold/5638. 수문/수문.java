import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static boolean[] select;
  static long[][] waterGate;
  static ArrayList<Cost> list;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    N = Integer.parseInt(br.readLine());
    select = new boolean[N];
    waterGate = new long[N][2];
    list = new ArrayList<Cost>();
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      long F = Long.parseLong(st.nextToken());
      long C = Long.parseLong(st.nextToken());
      waterGate[i][0] = F;
      waterGate[i][1] = C;
    }
    func(0);
    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i=1;i<=M;i++){
      st = new StringTokenizer(br.readLine());
      long V = Long.parseLong(st.nextToken());
      long T = Long.parseLong(st.nextToken());
      long min = Long.MAX_VALUE;
      for(Cost c : list){
        if(c.total * T >= V){
          min = Math.min(min, c.cost);
        }
      }
      sb.append("Case ").append(i).append(": ").append(min != Long.MAX_VALUE ? min : "IMPOSSIBLE").append("\n");
    }
    System.out.println(sb.toString());
  }
  static void func(int idx){
    if(idx == N){
      long total = 0;
      long cost = 0;
      for(int i=0;i<N;i++){
        if(select[i]){
          total += waterGate[i][0];
          cost += waterGate[i][1];
        }
      }
      if(total != 0) list.add(new Cost(total, cost));
      return;
    }
    select[idx] = true;
    func(idx+1);
    select[idx] = false;
    func(idx+1);
  }
}

class Cost{
  long total;
  long cost;

  public Cost(long total, long cost){
    this.total = total;
    this.cost = cost;
  }
}

