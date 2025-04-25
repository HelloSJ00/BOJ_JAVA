import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < testCase ; i++){
            int curCase = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][curCase+1];
            int answer = 0;
            for(int j = 0 ; j < 2 ; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1 ; k <= curCase ; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][curCase+1];
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            if(curCase > 1){
                dp[0][2] = dp[1][1] + sticker[0][2];
                dp[1][2] = dp[0][1] + sticker[1][2]; 
            }
            
            for(int j = 3 ; j <= curCase ; j++){
                dp[0][j] = Math.max(dp[1][j-1],dp[1][j-2]) + sticker[0][j];
								// System.out.println(Math.max(dp[1][j-1],dp[1][j-2]));
								// System.out.println(sticker[0][j]);
                dp[1][j] = Math.max(dp[0][j-1],dp[0][j-2]) + sticker[1][j];
            }
            
            answer = Math.max(dp[0][curCase],dp[1][curCase]);
            System.out.println(answer);
            
        }
    }
}