import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+1][N+1];
        
        for(int i = 1 ; i<= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= i ; j++ ){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N+1][N+1];
        
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(j == 1){
                    dp[i][j] = arr[i][j] + dp[i-1][j];   
                } else if(j== i){
                    dp[i][j] = arr[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + arr[i][j];
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1 ; i <= N ; i++){
            answer = Math.max(dp[N][i],answer);
        }
        System.out.print(answer);
    }
}