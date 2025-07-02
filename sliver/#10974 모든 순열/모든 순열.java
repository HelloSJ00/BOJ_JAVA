import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] arr;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N+1];
        
        for(int i = 1 ; i <= N ; i++){
            arr[i] = true;
            recur(1,String.valueOf(i));
            arr[i] = false;
        }
        
        System.out.print(sb.toString().trim());
    }
    
    public static void recur(int depth,String s){
        if(depth == N){
            sb.append(s+"\n");
        } else {
            for(int i = 1 ; i <= N ; i++){
                if(!arr[i]){
                    arr[i] = true;
                    recur(depth+1,s+" "+String.valueOf(i));
                    arr[i] = false;
                }
            }
        }
    }
}