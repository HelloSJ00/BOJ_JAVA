import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		boolean[] dp =  new boolean[1001];
		dp[1] = true;
		dp[2] = false;
		dp[3] = true;
		for(int i = 4; i <= N ; i++){
			if(dp[i-3]) dp[i] = false;
			else dp[i] = true;
		}

		if(dp[N]) System.out.println("SK");
		else System.out.println("CY");
	}

}