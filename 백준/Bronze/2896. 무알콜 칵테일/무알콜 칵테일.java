import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    double A = Integer.parseInt(st.nextToken());
    double B = Integer.parseInt(st.nextToken());
    double C = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    double I = Integer.parseInt(st.nextToken());
    double J = Integer.parseInt(st.nextToken());
    double K = Integer.parseInt(st.nextToken());

    double x1 = A / I;
    double x2 = B / J;
    double x3 = C / K;

    double min = Math.min(Math.min(x1, x2), x3);
    double ansA = A - I * min;
    double ansB = B - J * min;
    double ansC = C - K * min;
    System.out.println(ansA+" "+ansB+" "+ansC);
  }
}