import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        for(int i = 0 ; i < N ; i++){
            recur(0,String.valueOf(arr[i]),arr[i]);
        }
        
        System.out.print(sb.toString());
         
    }
    
    public static void recur(int depth, String s, int prev){
        if(depth == M - 1){
            sb.append(s);
            sb.append("\n");
            return;
        } else {
            for(int i = 0 ; i < N ; i++){
                if(arr[i] >= prev ){
                    recur(depth+1,s+" "+String.valueOf(arr[i]),arr[i]);
                }
            }
        }
    }
}