import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] price = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];
        dp[1] = price[1];
        for(int i = 2 ; i <= N ; i++){
            // dp[i]값 구해야함
            int tmp = price[i] ;
            for(int j = 1; j <= i ; j++){
                tmp = Math.max(tmp,dp[i-j]+dp[j]);
            }
            dp[i] = tmp;
        }
        System.out.println(dp[N]);
    }
}