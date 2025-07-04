import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int L;
    static int C;
    static String[] arr;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ; i++){
            arr[i] = st.nextToken();
        }
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < C ; i++){
            findCase(1,arr[i],i);
        }
        
        System.out.print(sb.toString());
    }
    public static void findCase(int depth,String s,int prev){
        if(depth == L){
            // 유효성 검증
            String[] tmp = s.split("");
            int mo = 0;
            int ja = 0;
            for(String ss : tmp){
                if( 
                   ss.equals("a") ||
                   ss.equals("e") ||
                   ss.equals("i") ||
                   ss.equals("o") ||
                   ss.equals("u")
                  ) mo++;
                else ja++;
            }
            
            if(mo >= 1 && ja >=2){
                sb.append(s+"\n");
            }
        } else {
            for(int i = prev+1 ; i < C ; i++){
                findCase(depth+1,s+arr[i],i);
            }
        }
    }
}