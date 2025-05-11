import java.io.*;
import java.util.*;

public class Main{
    static int N = 0 ;
    static int length = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        
        bt(1,"",0);
        System.out.print(sb.toString());
    }
    
    public static void bt(int depth,String s,int prev){
        if(depth == length+1){
            sb.append(s);
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= N ; i++){
            if(prev <= i){
                bt(depth+1,s+(String.valueOf(i)+" "),i);
            }
        }
    }
}