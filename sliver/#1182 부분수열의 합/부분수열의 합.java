import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N ;
    static int S ;
    static int[] arr;
    static StringTokenizer st;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0 ; i < N ; i++){
            findZero(arr[i],i);
        }
        
        System.out.print(result);
    }
    
    public static void findZero(int sum,int prev){
        if(sum == S) result ++;
        
        for(int i = prev + 1 ; i < N ; i++){
            findZero(sum+arr[i],i);
        }

    }
    
}