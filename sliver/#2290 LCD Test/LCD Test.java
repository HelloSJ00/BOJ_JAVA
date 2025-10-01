import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static int s;
	static String[] n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken().split("");

		lcd();

		System.out.println(sb.toString());
	}

	static void lcd(){
		for(int i = 0 ; i < n.length ; i++){
			floor1(Integer.parseInt(n[i]));
		}

		sb.append("\n");
		for(int i = 0 ; i < s ; i++){
			for(int j = 0 ; j < n.length ; j++){
				floor2(Integer.parseInt(n[j]));
			}
			sb.append("\n");
		}
		for(int i = 0 ; i < n.length ; i++){
			floor3(Integer.parseInt(n[i]));
		}

		sb.append("\n");
		for(int i = 0 ; i < s ; i++){
			for(int j = 0 ; j < n.length ; j++){
				floor4(Integer.parseInt(n[j]));
			}
			sb.append("\n");
		}
		for(int i = 0 ; i < n.length ; i++){
			floor5(Integer.parseInt(n[i]));
		}
	}

	static void floor1(int a){
		if(a == 2 || a == 3||a == 5||a == 6||a == 7||a == 8||a == 9||a==0){
			sb.append(" ");
			for(int i = 0 ; i < s ; i++){
				sb.append("-");
			}
			sb.append(" ");
		} else {
			for(int i = 0 ; i < s+2 ; i++){
				sb.append(" ");
			}
		}
		sb.append(" ");
	}

	static void floor2(int a){
		// 2층
		if(a == 1||a == 2||a == 3||a == 7){
			for(int i = 0 ; i < s+1 ; i ++){
				sb.append(" ");
			}
			sb.append("|");
		}else if(a == 4||a == 8||a == 9||a == 0){
			sb.append("|");
			for(int i = 0 ; i < s ; i ++){
				sb.append(" ");
			}
			sb.append("|");
		} else {
			sb.append("|");
			for(int i = 0 ; i < s+1 ; i ++){
				sb.append(" ");
			}
		}
		sb.append(" ");
	}

	static void floor3(int a){
		// 3층
		if(a==1 || a== 7 || a==0){
			for(int i = 0 ; i < s+2;i++){
				sb.append(" ");
			}
		} else {
			sb.append(" ");
			for(int i = 0 ; i < s ; i++){
				sb.append("-");
			}
			sb.append(" ");
		}
		sb.append(" ");
	}

	static void floor4(int a){
				// 4층
		if(a == 1||a == 3||a == 4||a == 5 || a== 7|| a == 9){
			for(int i = 0 ; i < s+1 ; i ++){
				sb.append(" ");
			}
			sb.append("|");
		}else if(a == 6||a == 8||a == 0){
			sb.append("|");
			for(int i = 0 ; i < s ; i ++){
				sb.append(" ");
			}
			sb.append("|");
		} else {
			sb.append("|");
			for(int i = 0 ; i < s+1 ; i ++){
				sb.append(" ");
			}
		}
		sb.append(" ");
	}
	
	static void floor5(int a){
		// 5층
		if(a==1 || a== 4 || a==7){
			for(int i = 0 ; i < s+2;i++){
				sb.append(" ");
			}
		} else {
			sb.append(" ");
			for(int i = 0 ; i < s ; i++){
				sb.append("-");
			}
			sb.append(" ");
		}
		sb.append(" ");
	}

}