import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean findCircle;
    static int N;
    static List<List<Integer>> subway = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static boolean[] visit;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        parent = new int[N+1];
        for(int i = 0 ; i <= N ; i++ ){
            subway.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            subway.get(a).add(b);
            subway.get(b).add(a);
        }
        
        findCircle();
        
      
        for(int i = 1 ; i <= N ; i++){
            sb.append(findDistance(i)+" ");
        }
        
        
        
        System.out.print(sb.toString());
    }
    
    public static void findCircle(){
        visit[1] = true;
        parent[1] = -1;
        
        for(int next : subway.get(1)){
            dfs(next,1);
        }
    }
    
    public static void dfs(int c,int p){
        visit[c] = true;
        parent[c] = p;
        
        for(int next : subway.get(c)){
            if(findCircle) return;
            if(next == p){
                continue;
            } else if(visit[next] == true && !findCircle){
                int curr = c;
                while(curr != next){
                    set.add(curr);
                    curr = parent[curr];
                }
                findCircle = true;
                set.add(next);
                return;
            } else {
                dfs(next,c);
            }
        }
    }
    
    public static int findDistance(int i){
        if(set.contains(i)) return 0;
        
        int result = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(new int[]{i,0});
        visited[i] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int next : subway.get(cur[0])){
                if(!set.contains(next) && !visited[next]){
                    q.add(new int[]{next,cur[1]+1});
                    visited[next] = true;
                } else if(set.contains(next)){
                    result = Math.min(result,cur[1]+1);
                }
            }
        }
        
        return result;
    }
    
}