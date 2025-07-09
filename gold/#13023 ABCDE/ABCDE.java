import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static StringTokenizer st;
    static boolean[] visited;
    static List<List<Integer>> map ;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        
        map = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            map.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        for(int i = 0 ; i < N ; i++){
            if(result==1) break;
            visited[i] = true;
            findRoute(i,1);
            visited[i] = false;
        }
        
        System.out.print(result);
        
    }
    
    public static void findRoute(int prev,int depth){
        if(result==1) return;
        if(depth == 5){
            result = 1;
            return;
        } else {
            for(int next : map.get(prev)){
                if(!visited[next]){
                    visited[next] = true;
                    findRoute(next,depth+1);
                    visited[next] = false;
                }
            }
        }
    }
}