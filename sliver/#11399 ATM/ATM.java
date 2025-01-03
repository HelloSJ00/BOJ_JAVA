import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] peoples = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++){
			peoples[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(Solution(N,peoples));

	}
	public static int Solution(int N,int[] peoples){
		int[] dp = new int[N+1];
		Arrays.sort(peoples);

		dp[1] = peoples[1];
		for(int i = 2; i<= N ; i++){
			dp[i] = dp[i-1] + peoples[i];
		}

		int sum = 0;
		for(int i = 1; i <= N ; i++){
			sum += dp[i];
		}
		return sum;
	}
}