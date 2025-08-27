import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int start;
    static int end;
    static List<List<int[]>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i <= N ; i++){
            g.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            g.get(a).add(new int[]{b,value});
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[1]));
        pq.offer(new int[]{start,0});
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curIndex = cur[0];
            int curValue = cur[1];
                            
            if(visit[curIndex]) continue;
            visit[curIndex] = true;

            for(int[] next : g.get(curIndex)){
            
                int nextIndex = next[0];
                int nextValue = curValue + next[1];

                
                if(dist[nextIndex] > nextValue){
                    // visit[nextIndex] = true;
                    dist[nextIndex] = nextValue;
                    pq.offer(new int[]{nextIndex,nextValue});
                }
            }
            
            
        }
        
        System.out.print(dist[end]);
        
    }
}