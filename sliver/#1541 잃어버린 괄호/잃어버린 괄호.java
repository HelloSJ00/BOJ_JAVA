import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int answer = 0;
		int tmp = 0;
		StringBuilder tmpString = new StringBuilder();

		boolean subMode = false;

		for (char c : input.toCharArray()){
			if(Character.isDigit(c)){
				tmpString.append(c);
			}
			else if( c == '+'){
				tmp += Integer.parseInt(tmpString.toString());
				tmpString = new StringBuilder();
			} 
			else if (c == '-'){
				tmp += Integer.parseInt(tmpString.toString());
				if(!subMode){
					answer += tmp;
				}
				else{
					answer -= tmp;
				}
				subMode = true;
				tmp = 0;
				tmpString = new StringBuilder();
			} 
		}

		tmp += Integer.parseInt(tmpString.toString());
		if(!subMode){
			answer += tmp;
		}else{
			answer -= tmp;
		}

		System.out.print(answer);
	}
}