import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] arr;
    static int[] intArr;
    static boolean[] visited = new boolean[10];
    static StringTokenizer st;
    static String minStr ="";
    static String maxStr ="";
    static long minValue = Long.MAX_VALUE;
    static long maxValue = Long.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new String[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1 ; i <= N ; i++ ){
            arr[i] = st.nextToken();
        }
        
        intArr = new int[N+1];
        
        
        for(int i = 0 ; i < 10 ; i++){
            visited[i] = true;
            findArr(1,String.valueOf(i),i);
            visited[i] = false;
        }
        
        System.out.print(maxStr + "\n" + minStr);
    }
    
    public static void findArr(int depth,String s,int prev){
        if(depth == N+1)
        {
            if(minValue > Long.parseLong(s)){
                minValue = Long.parseLong(s);
                minStr = s;
            } else if(maxValue < Long.parseLong(s)){
                maxValue = Long.parseLong(s);
                maxStr = s;
            }
        }else {
            if(arr[depth].equals("<")){
            for(int i = prev+1 ; i < 10 ; i++){
                if(!visited[i]){
                    visited[i] = true;
                    findArr(depth+1,s+String.valueOf(i),i);
                    visited[i] = false;
                }
            }
        } else {
            for(int i = 0 ; i < prev ; i++){
                if(!visited[i]){
                    visited[i] = true;
                    findArr(depth+1,s+String.valueOf(i),i);
                    visited[i] = false;
                }
            }
        }
        }
        
        
    }
}