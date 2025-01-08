import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[101];
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		dp[4] = 2L;
		dp[5] = 2L;
		for(int i = 6; i <= 100;i++){
			dp[i] = dp[i-1]+dp[i-5];
		}

		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < tc ; i++){
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append('\n');
		}

		System.out.print(sb);
	}
}