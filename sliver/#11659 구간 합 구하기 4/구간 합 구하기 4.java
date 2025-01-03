import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N+1];
		for(int i = 1; i <= N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];

		dp[1] =  arr[1];
		for(int i = 2; i<= N ; i ++){
			dp[i] = dp[i-1] + arr[i];
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[end]-dp[start-1]).append('\n');
		}

		System.out.print(sb);
	}
}