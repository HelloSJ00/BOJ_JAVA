import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer st;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> g = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i <= N ; i++){
            g.add(new ArrayList<>());
        }
        
        parent = new int[N+1];
        
        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            g.get(a).add(b);
            g.get(b).add(a);
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : g.get(cur)){
                if(parent[next] == 0){
                    parent[next] = cur;
                    q.add(next);        
                }

            }
        }
        
        for(int i = 2; i <= N ; i++){
            sb.append(parent[i]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}