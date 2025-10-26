import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String ML = st.nextToken();
		String MR = st.nextToken();
		String TL = st.nextToken();
		String TR = st.nextToken();

		if(ML.equals(MR)){
			if(ML.equals("R")){
				if(TL.equals("P") || TR.equals("P")){
					System.out.println("TK");
				}else if(TL.equals("R") || TR.equals("R")){
					System.out.println("?");
				}else{
					System.out.println("MS");
				}
			}else if(ML.equals("S")){
				if(TL.equals("R") || TR.equals("R")){
					System.out.println("TK");
				}else if(TL.equals("S") || TR.equals("S")){
					System.out.println("?");
				}else{
					System.out.println("MS");
				}
			}else if(ML.equals("P")){
				if(TL.equals("S") || TR.equals("S")){
					System.out.println("TK");
				}else if(TL.equals("P") || TR.equals("P")){
					System.out.println("?");
				}else{
					System.out.println("MS");
				}
			}
		}else if(TL.equals(TR)){
			if(TL.equals("R")){
				if(ML.equals("P") || MR.equals("P")){
					System.out.println("MS");
				}else if(ML.equals("R") || MR.equals("R")){
					System.out.println("?");
				}else{
					System.out.println("TK");
				}
			}else if(TL.equals("S")){
				if(ML.equals("R") || MR.equals("R")){
					System.out.println("MS");
				}else if(ML.equals("S") || MR.equals("S")){
					System.out.println("?");
				}else{
					System.out.println("TK");
				}
			}else if(TL.equals("P")){
				if(ML.equals("S") || MR.equals("S")){
					System.out.println("MS");
				}else if(ML.equals("P") || MR.equals("P")){
					System.out.println("?");
				}else{
					System.out.println("TK");
				}
			}
		}else{
			System.out.println("?");
		}
	}
}