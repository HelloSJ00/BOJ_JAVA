import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < testCase ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(Solution(N,M,x,y)).append('\n');
		}
		System.out.println(sb);
	}

	public static int Solution(int N,int M,int x,int y){
		int lcm = 0;

		if( N>=M){
			lcm = LCM(N,M);
		} else{
			lcm = LCM(M,N);
		}

		int countOfN = (int)(lcm-x)/N;

		for(int i = 0 ; i<= countOfN ; i++){
			if(y == M){
				if((N*i+x)%M == 0 ){
					return N*i+x;
				}
			} else if((N*i+x)%M == y) return N*i+x;
		}
		return -1;
	}

	public static int GCD(int a,int b){
		while(b!=0){
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}

	public static int LCM(int a,int b){
		return (a*b)/GCD(a,b);
	}
}