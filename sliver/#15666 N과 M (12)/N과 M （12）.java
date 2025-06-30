import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] arr;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        for(int i = 0 ; i < N ; i++){
            recur(1,String.valueOf(arr[i]),arr[i]);
        }
        
        System.out.println(sb.toString());
    }
    
    public static void recur(int depth,String s,int prev){
        if(depth == M  ){
            if(!set.contains(s)){
                set.add(s);
                sb.append(s);
                sb.append("\n");
            }
            return;
        } else {
            for(int i = 0 ; i < N ; i++){
                if(arr[i] >= prev){
                    recur(depth+1,s+" "+String.valueOf(arr[i]),arr[i]);
                }
            }
        }
    }}
    