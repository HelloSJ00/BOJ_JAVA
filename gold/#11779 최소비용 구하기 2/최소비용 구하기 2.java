import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        List<List<int[]>> g = new ArrayList<>();
        for(int i = 0 ; i <= 1000 ; i ++){
            g.add(new ArrayList<>());
        }

        int[] dist = new int[1001];
        Arrays.fill(dist,Integer.MAX_VALUE);

        int[] parent = new int[1001];

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g.get(s).add(new int[]{e,v});
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[1]));
        pq.offer(new int[]{start,0});
        dist[start] = 0;
        parent[start] = -1;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int curNode = cur[0];
            int curValue = cur[1];

            if(dist[curNode] < curValue) continue;
            for(int[] next : g.get(curNode)){
                int nextNode = next[0];
                int nextValue = curValue + next[1];

                if(dist[nextNode] > nextValue){
                    dist[nextNode] = nextValue;
                    parent[nextNode] = curNode;
                    pq.offer(new int[]{nextNode,nextValue});
                }
            }
        }

        System.out.println(dist[end]);
        int cnt = 1;
        String route = String.valueOf(end);

        int back = parent[end];
        while(back != -1){
            route = String.valueOf(back) +  " " + route;
            back = parent[back];
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(route);
    }
}