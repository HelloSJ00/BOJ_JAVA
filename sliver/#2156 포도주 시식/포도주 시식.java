import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        
        for(int i = 1; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] dp = new int[N+1][4];
        
        dp[1] = new int[]{
            dp[0][0]+arr[1], // o - o
            arr[1], // x - o
            dp[0][0], // o - x
            0 // x -x
        };
        
        for(int i = 2 ;  i <= N ; i++){
            dp[i] = new int[]{
                dp[i-1][1]+arr[i],
                Math.max(dp[i-1][2],dp[i-1][3]) + arr[i],
                Math.max(dp[i-1][0],dp[i-1][1]),
                Math.max(dp[i-1][2],dp[i-1][3])
            };
        }
        
        int answer = 0 ;
        for(int i = 0 ; i < 4 ; i++){
            answer = Math.max(dp[N][i],answer);
        }
        System.out.print(answer);
    }
}