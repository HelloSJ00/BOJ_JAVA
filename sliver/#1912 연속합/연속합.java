import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];
        dp[1] = arr[1];
        for(int i = 2 ; i <= N ; i++){
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
        }
        
        int answer = Integer.MIN_VALUE ;
        for(int i = 1 ; i <= N ; i++){
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
        
    }
}