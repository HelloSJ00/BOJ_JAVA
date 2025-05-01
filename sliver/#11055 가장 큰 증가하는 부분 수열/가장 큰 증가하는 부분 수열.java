import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];
        for(int i = 1 ; i <= N ; i ++){
            dp[i] = arr[i];
        }
        
        for(int i = 2 ; i <= N ; i++){
            for(int j = 1 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+arr[i],dp[i]);
                }
            }
        }
        
        int answer = 0;
        for(int i = 1 ; i <= N ; i++){
            answer = Math.max(answer,dp[i]);
        }
        
        System.out.print(answer);
    }
}