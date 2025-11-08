import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		if(m == 0){
			sb.append(hour(h)).append(" ").append(minute(m));
		}else if(m == 15 || m == 30){
			sb.append(minute(m)).append(" past ").append(hour(h));
		}else if(m == 1){
			sb.append(minute(m)).append(" minute past ").append(hour(h));
		}else if(m < 30){
			sb.append(minute(m)).append(" minutes past ").append(hour(h));
		}else if(m == 45){
			sb.append(minute(m)).append(" to ").append(hour(h+1));
		}else if(m == 59){
			sb.append(minute(m)).append(" minute to ").append(hour(h+1));
		}else{
			sb.append(minute(m)).append(" minutes to ").append(hour(h+1));
		}
		System.out.println(sb.toString());
	}

	static String hour(int h){
		h = h % 12;
		switch(h){
			case 1 : return "one";
			case 2 : return "two";
			case 3 : return "three";
			case 4 : return "four";
			case 5 : return "five";
			case 6 : return "six";
			case 7 : return "seven";
			case 8 : return "eight";
			case 9 : return "nine";
			case 10 : return "ten";
			case 11 : return "eleven";
			default : return "twelve";
		}
	}

	static String minute(int m){
		String[] one = {
			"o' clock","one","two","three","four","five","six","seven","eight","nine",
			"ten","eleven","twelve","thirteen","fourteen","quarter","sixteen",
			"seventeen","eighteen","nineteen"
		};
		String[] ten = {"", "", "twenty", "half"};
		if(m > 30){
			m = 60 - m;
		}
		if(m < 20){
			return one[m];
		}
		if(m % 10 == 0){
			return ten[m / 10];
		}
		return ten[m / 10] +" " + one[m % 10];
	}
}