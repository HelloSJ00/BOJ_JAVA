import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] arr;
    static boolean[] visited;
    static StringTokenizer st;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = st.nextToken();
        }
        for(int i = 0 ; i < N ; i ++){
            visited[i] = true;
            findValue(1,String.valueOf(arr[i]));
            visited[i] = false;
        }
        
        System.out.print(answer);
    }
    
    public static void findValue(int depth,String s){
        if(depth == N){
            
            String[] sarr = s.split(" ");
            // System.out.println(Arrays.toString(sarr));
            int result = 0;
            for(int i = 0 ; i < N-1 ; i++){
                result += Integer.parseInt(sarr[i])-Integer.parseInt(sarr[i+1]) > 0 ? 
                    Integer.parseInt(sarr[i])-Integer.parseInt(sarr[i+1]) 
                    : -(Integer.parseInt(sarr[i])-Integer.parseInt(sarr[i+1]));
            }
            
            if(result > answer){
                answer = result;
            }
            return;
        } else {
            for(int i = 0 ; i < N ; i++){
                if(!visited[i]){
                    visited[i] = true;  
                    findValue(depth+1,s+" "+String.valueOf(arr[i]));
                    visited[i] = false;
                }
                
            }
        }
        
    }
}