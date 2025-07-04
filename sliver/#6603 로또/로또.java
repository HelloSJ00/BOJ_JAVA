import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
          
    
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   
            if(N == 0) break;
            
            arr = new int[N];
            for(int i = 0 ; i < N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 0 ; i < N - 5 ; i++){
                findCase(1,String.valueOf(arr[i]),i);
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static void findCase(int depth,String s,int prev){
        if(depth == 6){
            sb.append(s+"\n");
        } else {
            for(int i = prev+1 ; i < N ; i++){
                if((N-1-i) + (depth +1) >= 6){
                    findCase(depth+1,s+" "+String.valueOf(arr[i]),i);
                }
            }
        }
    }
}