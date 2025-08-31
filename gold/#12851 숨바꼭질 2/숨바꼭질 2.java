import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int K;
    static int[] dist = new int[100_001];
    static int[] count = new int[100_001];
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[N] = 0;
        count[N] = 1;

        int rt = Math.max(N,2*K);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[1]));
        pq.offer(new int[]{N,dist[N]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            int curNode = cur[0];

            int curDist = cur[1];

            if(curNode == K || curNode > rt ) continue;


            int nextNode = curNode - 1;
            if(nextNode >= 0){
                if(dist[nextNode] > curDist+1){
                    dist[nextNode] = curDist+1;
                    count[nextNode] = 1;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                } else if(dist[nextNode] == curDist+1){
                    count[nextNode]++;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                }
            }
            
            nextNode = curNode + 1;
            if(nextNode < 100_001){
                if(dist[nextNode] > curDist+1){
                    dist[nextNode] = curDist+1;
                    count[nextNode] = 1;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                } else if(dist[nextNode] == curDist+1){
                    count[nextNode]++;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                }
            }

            nextNode = 2*curNode;
            if(nextNode < 100_001){
                if(dist[nextNode] > curDist+1){
                    dist[nextNode] = curDist+1;
                    count[nextNode] = 1;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                } else if(dist[nextNode] == curDist+1){
                    count[nextNode]++;
                    pq.offer(new int[]{nextNode,dist[nextNode]});
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(count[K]);
    }
}