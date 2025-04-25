import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] testCaseNum = new int[testCase];
        long num = 1_000_000_009;
        
				int length = 0; 
				for(int i = 0 ; i < testCase ; i++){
					int cur = Integer.parseInt(br.readLine());
					testCaseNum[i] = cur;
					length = Math.max(length,cur);
				}

				long[] dp = new long[length+1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;

				for(int i = 4 ; i <= length ; i++){
					dp[i] = (dp[i-3]%num + dp[i-2]%num + dp[i-1]%num)%num;
				}

				for(int i = 0 ; i < testCase ; i++){
					// System.out.println(testCaseNum[i]);
					System.out.println(dp[testCaseNum[i]]);
				}

    }
}