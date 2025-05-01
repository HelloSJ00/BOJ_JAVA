import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][2];
        for (int i = 0; i <= N; i++) {
            dp[i] = new int[]{1, 1}; // 각각 새 배열
        }
 
        
        // 1 증가 2 감소
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1; j < i ; j++){
                if(arr[j] < arr[i]){
                    dp[i][0] = Math.max(dp[i][0],dp[j][0]+1);
                }
                
                if(arr[N + 1 - j] < arr[N + 1 - i]){
                    dp[N + 1 - i][1] = Math.max(dp[N+1-i][1],dp[N+1-j][1]+1);
                }
            }
        }

        
        int answer = 0 ;
        
        for(int i = 1; i <= N ; i++){
            answer = Math.max(answer,dp[i][0]+dp[i][1]-1);
        }
        
        
        System.out.println(answer);
    }
}