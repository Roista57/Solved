import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    long P = Long.parseLong(st.nextToken());

    boolean flag = true;
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      int cnt = 0;
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(int j=0;j<M;j++){
        int num = Integer.parseInt(st.nextToken());
        if(num == -1) cnt++;
        else{
          list.add(num);
        }
      }
      Collections.sort(list);
      int idx = 0;
      while(idx < list.size() && flag){
        if(P < list.get(idx)){
          if(cnt > 0){
            P = P * 2;
            cnt--;
          }
          else flag = false;
        }else{
          P += list.get(idx);
          idx++;
        }
      }
      for(int j=0;j<cnt;j++){
        P = P * 2;
      }
    }
    System.out.println(flag ? 1 : 0);
  }
}