import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N+1];

		for (int i = 1; i< N+1;i ++){
			int tmp = Integer.parseInt(br.readLine());
			numArr[i] = tmp;
		}

		System.out.print(Solution(numArr,N));
	}

	public static int Solution(int[] numArr,int N){
		int[] dp = new int[N+1];
		dp[1] = numArr[1];
		if(N >= 2){
			dp[2] = numArr[1]+ numArr[2];

			for(int i = 3; i< N+1;i++){
				dp[i] = Math.max(dp[i-3]+numArr[i-1]+numArr[i],dp[i-2]+numArr[i]);
			}
		}
		return dp[N];
	}
}