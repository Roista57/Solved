import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int five = N / 5;
    N = N % 5;
    int total = -1;
    while(true){
      if(N%2 == 0){
        total = five + N/2;
        break;
      } else{
        if(five == 0) break;
        five--;
        N += 5;
      }
    }
    System.out.println(total);
  }
}