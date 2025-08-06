import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<int[]>> g = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int V;
    static int E;
    static int K;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i <= V ; i ++){
            g.add(new ArrayList<>());
        }

        for(int i = 0 ; i < E ; i ++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[1]));
        pq.offer(new int[]{K,0});
        dist[K] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curWeight = cur[1];

            for(int[] next : g.get(curNode)){
                int nextNode = next[0];
                int nextWeight = next[1];

                if(curWeight+nextWeight < dist[nextNode]){
                    dist[nextNode] = curWeight+nextWeight;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                }
            }
        }

        for(int i = 1 ; i <= V ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}