import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] answerNum = new int[tc];
        int mod = 1_000_000_009;
        int max = 0 ;
        for(int i = 0 ; i < tc ; i++){
            int tmp = Integer.parseInt(br.readLine()); 
            answerNum[i] = tmp;
            max = Math.max(max,tmp);
        }
        
        long[][] dp = new long[Math.max(max,3)+1][4];
        dp[1] = new long[]{0,1,0,0};
        dp[2] = new long[]{0,0,1,0};
        dp[3] = new long[]{0,1,1,1};
        
        for(int i = 4 ; i <= max ; i++){
            dp[i] = new long[]{0,
                (dp[i-1][2]+dp[i-1][3])%mod,
                (dp[i-2][1]+dp[i-2][3])%mod,
                (dp[i-3][1]+dp[i-3][2])%mod};
        }
        
        for(int t : answerNum){
            System.out.println((dp[t][1]+dp[t][2]+dp[t][3])%mod);
        }
        
        
    }
}