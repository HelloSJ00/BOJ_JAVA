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
        
        int[][] dp = new int[N+1][2];
        for(int i = 1 ;i <= N ; i++){
            dp[i] = new int[]{arr[i],arr[i]};
        }
        // for(int[] t : dp ){
        //     System.out.println(Arrays.toString(t));
        // }
        for(int i = 2 ; i <= N ; i++){
            dp[i][0] = Math.max(dp[i][0],dp[i-1][0]+arr[i]);
            dp[i][1] = Math.max(dp[i][1],Math.max(dp[i-1][0],dp[i-1][1]+arr[i]));
        }
        
        // for(int[] t : dp ){
        //     System.out.println(Arrays.toString(t));
        // }

        int answer = Integer.MIN_VALUE ;
        for(int i = 1 ; i<= N ; i++){
            answer = Math.max(answer,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(answer);
    }
}