import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long mod = 1_000_000_000;
        long[][] dp = new long[N+1][11];
        dp[1] = new long[]{0,1,1,1,1,1,1,1,1,1};
        
        for(int i = 2 ; i <= N ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(j==0) {
                    dp[i][j] = dp[i-1][j+1];
                } else if(j==9){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
                }
            }
        }
        long answer = 0;
        for(int i = 0; i < 10 ; i++){
            answer = (answer+dp[N][i])%mod;
        }
        System.out.println(answer);
    }
}