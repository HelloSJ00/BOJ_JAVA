import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int TC;
    static int V;
    static int E;
    static List<List<Integer>> map;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++){
            if(isBinaryGraph()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    public static boolean isBinaryGraph() throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        
        for(int i = 0 ; i <= V ; i++){
            map.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        boolean[] visited = new boolean[V+1];
        for(int i = 1 ; i <= V ; i++){
            if(!visited[i]){
                Set<Integer> s1 = new HashSet<>();
                Set<Integer> s2 = new HashSet<>();
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i,0});
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int cur_v = cur[0];
                    int cur_s = cur[1];
                    
                    visited[cur_v] = true;
                    if(cur_s == 0){
                        for(int v : map.get(cur_v)){
                            if(!s2.contains(v)){
                                s2.add(v);
                                q.add(new int[]{v,1});
                            }
                        }
                    } else {
                        for(int v : map.get(cur_v)){
                            if(!s1.contains(v)){
                                s1.add(v);
                                q.add(new int[]{v,0});
                            }
                        }
                    }
                }
                
                for(int k : s1){
                    for(int j :s2){
                        if(k == j) return false;
                    }
                }
            }
        }
        return true;
    }
}