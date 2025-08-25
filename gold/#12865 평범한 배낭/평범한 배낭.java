import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static int[][] dp;
    static int[][] things;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        things = new int[N+1][2];
        dp = new int[K+1][N+1];
        
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            things[i] = new int[]{
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            };
        }
        
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= K ; j++){
                if(things[i][0] <= j){
                    // System.out.println("d");
                    dp[j][i] = Math.max(things[i][1]+dp[j-things[i][0]][i-1],dp[j][i-1]);
                } else {
                    dp[j][i] = dp[j][i-1];
                }
            }
        }

        // for(int i = 0 ; i <= N ; i++){
        //     System.out.println(Arrays.toString(things[i]));
        // }
        // for(int i = 0 ; i <= K ; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.println(dp[K][N]);
    }
}