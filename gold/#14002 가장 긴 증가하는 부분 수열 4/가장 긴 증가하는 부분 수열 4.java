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
        Arrays.fill(dp,1);
        dp[0] = 0;
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            l.add(new ArrayList<>());
        }
        
        l.get(1).add(arr[1]);
        for(int i = 2; i <= N ; i++){
            for(int j = 1 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        l.set(i,new ArrayList<>(l.get(j)));
                    }
                }
            }
            l.get(i).add(arr[i]);
        }
        
        int answerIdx = 0;
        int maxLength = 0;
        for(int i = 1 ; i <= N ; i++){
            if(dp[i] > maxLength){
                answerIdx = i;
                maxLength = dp[i];
            }
        }
        System.out.println(maxLength);
        for(int i = 0 ; i < maxLength ; i++){
            System.out.print(l.get(answerIdx).get(i)+" ");
        }
        // System.out.println(l.get(answerIdx));
    }
}