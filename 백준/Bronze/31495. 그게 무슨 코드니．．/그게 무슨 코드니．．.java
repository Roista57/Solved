import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String ans = "";
    boolean flag = true;
    int N = line.length();
    for(int i=0;i<N;i++){
      if(i == 0 || i == N-1){
        if(line.charAt(i) != '"') flag = false;
      }else{
        ans += line.charAt(i);
      }
    }
    if(ans.length() == 0) flag = false;
    System.out.println(flag ? ans : "CE");
  }
}