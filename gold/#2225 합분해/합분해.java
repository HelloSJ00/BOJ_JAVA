import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long mod = 1_000_000_000;
        long[][] dp = new long[N+1][K+1];
        Arrays.fill(dp[0],1);
        for(int i = 0 ; i <= N ; i++){
            dp[i][1] = 1;
        }
        
        for(int i = 2 ; i <= K ; i++){
            for(int j = 1 ; j <= N ; j++){
                long tmp = 0;
                for(int p = 0 ; p < j ; p++){
                    tmp = (tmp+dp[p][i-1])%mod;
                }
                dp[j][i] = (tmp + dp[j][i-1])%mod;
            }
        }
        
        // for(long[] t : dp){
        //     System.out.println(Arrays.toString(t));
        // }
        System.out.print(dp[N][K]);
    }
}