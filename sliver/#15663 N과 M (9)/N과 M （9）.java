import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb =  new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < N ; i++){
            visited[i] = true;
            recur(0,String.valueOf(arr[i]));
            visited[i] = false;
        }
        
        System.out.print(sb.toString());
    }
    
    
    public static void recur(int depth,String s){
        if(depth == M-1 && !set.contains(s)){
            set.add(s);
            sb.append(s);
            sb.append("\n");
        } else {
            for(int i = 0 ; i< N ; i++){
                if(!visited[i]){
                    visited[i] = true;
                    recur(depth+1,s+" "+String.valueOf(arr[i]));
                    visited[i] = false;
                }
            }
        }
    }
}