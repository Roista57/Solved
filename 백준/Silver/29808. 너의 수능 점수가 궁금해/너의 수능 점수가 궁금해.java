import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());

		ArrayList<Score> listA = new ArrayList<Score>();
		ArrayList<Score> listB = new ArrayList<Score>();
		StringBuilder sb = new StringBuilder();

		listA.add(new Score(0, 0));
		listB.add(new Score(0, 0));
		for(int i=1;i<=200;i++){
			listA.add(new Score(i*508, i));
			listA.add(new Score(i*108, i));
		}

		for(int i=1;i<=200;i++){
			listB.add(new Score(i*212, i));
			listB.add(new Score(i*305, i));
		}

		Collections.sort(listA);
		Collections.sort(listB);
		int cnt = 0;
		if(S % 4763 == 0){
			S /= 4763;
			for(int i=0;i<listA.size();i++){
				for(int j=0;j<listB.size();j++){
					int num = listA.get(i).cost + listB.get(j).cost;
					if(num == S){
						sb.append(listA.get(i).num).append(" ").append(listB.get(j).num).append("\n");
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		if(cnt != 0){
			System.out.println(sb.toString());
		}
	}
}

class Score implements Comparable<Score>{
	int cost;
	int num;
	public Score(int cost, int num){
		this.cost = cost;
		this.num = num;
	}
	@Override
	public int compareTo(Score o){
		return this.num - o.num;
	}
}