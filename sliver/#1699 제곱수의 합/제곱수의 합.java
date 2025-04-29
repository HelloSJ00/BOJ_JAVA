import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            for(int j = 1 ; j <= Math.sqrt(i) ; j++){
                if(j*j == i) dp[i] = 1;
                else {
                    dp[i] = Math.min(dp[j*j]+dp[i-(int)Math.pow(j,2)],dp[i]);
                }
                
            }
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}