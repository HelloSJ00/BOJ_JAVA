import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int TC;
    static int N;
    static int M;
    static int W;
    static int[] dist;
    static List<int[]> g;
    public static void main(String[] args) throws Exception{
        TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC ; i++){
            g = new ArrayList<>();
            getAns();
        }

        System.out.println(sb.toString());
    }

    static void getAns() throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.add(new int[]{a,b,c});
            g.add(new int[]{b,a,c});
        }

        for(int i = 1 ; i <= W ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g.add(new int[]{a,b,-1*c});
        }

        Arrays.fill(dist,0);

        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = 0 ; j < g.size() ; j++){
                int[] cur = g.get(j);
                int from = cur[0];
                int to = cur[1];
                int weight = cur[2];
                if(dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]){
                    dist[to] = dist[from] + weight;
                }
            }
        }

        // System.out.println(Arrays.toString(dist));
        for(int j = 0 ; j < g.size() ; j++){
            int[] cur = g.get(j);
            int from = cur[0];
            int to = cur[1];
            int weight = cur[2];
            if(dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]){
                sb.append("YES\n");
                return;
            }
        }

        sb.append("NO\n");
    }
}