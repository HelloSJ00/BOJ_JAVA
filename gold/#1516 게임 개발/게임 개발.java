import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<List<Integer>> edges = new ArrayList<>();
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        int[] value = new int[N+1];
        int[] tmpDist = new int[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // Arrays.fill(tmpDist,Integer.MAX_VALUE);

        for(int i = 0 ; i <= N ; i++){
            edges.add(new ArrayList<>());
        }
        
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while(st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1) break;

                if(cnt == 0){
                    value[i] = tmp;
                    cnt++;
                } else {
                    parent[i] ++;
                    edges.get(tmp).add(i);
                }
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i ++){
            if(parent[i] == 0){
                dist[i] = value[i];
                q.offer(new int[]{i,value[i]});
            }
        }


        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int curNode = cur[0];
            int curDist = cur[1];

            for(int next : edges.get(curNode)){
                parent[next]--;
                if(parent[next] == 0){
                    if(dist[next]>curDist+value[next]){
                        
                        dist[next] = Math.max(curDist+value[next],tmpDist[next]);
                        q.offer(new int[]{next,dist[next]});
                    }
                } else {
                    
                    tmpDist[next] = Math.max(tmpDist[next],curDist + value[next]);
                }
            }
        }

        for(int i = 1; i<= N; i++){
            System.out.println(dist[i]);
        }
    }
}