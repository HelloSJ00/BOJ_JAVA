import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < N ; i++){
            recur(i,0,String.valueOf(arr[i]));
        }
        
        System.out.print(sb.toString());
    }
    
    public static void recur(int prev,int depth,String s){
        if(depth == M-1){
            sb.append(s);
            sb.append("\n");
        } else {
            for(int i = prev+1; i < N ; i++){
                recur(i,depth+1,s+" "+String.valueOf(arr[i]));
            }
        }
    }
}