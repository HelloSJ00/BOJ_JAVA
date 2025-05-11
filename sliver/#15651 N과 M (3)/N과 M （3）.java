import java.io.*;
import java.util.*;

public class Main{
    static int N = 0;
    static int length = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        int[] arr = new int[length+1];
        bt(arr,1,"");
        
        System.out.println(sb.toString());
    }
    
    public static void bt(int[] arr , int depth,String s){
        if(depth == length + 1){
            sb.append(s);
            sb.append("\n");
            return;
        }
       
        for(int i = 1 ; i <= N ; i++){
            bt(arr,depth+1,s+(String.valueOf(i)+" "));
        }
    }
}