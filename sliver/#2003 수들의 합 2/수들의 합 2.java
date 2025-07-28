import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }
        int result = 0;
        for(int i = 0 ; i <= N ; i ++){
            for(int j = 1 ; j <= N ; j++){
                if(arr[j] - arr[i] == M) result++;
            }
        }
        
        System.out.print(result);
    }
    
}