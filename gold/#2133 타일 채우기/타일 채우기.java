import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[Math.max(5,N+1)];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = dp[0]*2 + dp[2]*3;

        
        for(int i = 6 ; i <= N ; i += 2){
            for(int j = 0 ; j < i-2 ; j+=2 ){
                dp[i] += dp[j]*2;
            }
            dp[i] += dp[i-2]*3;
        }
        System.out.print(dp[N]);
    }
}