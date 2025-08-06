import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> g = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            g.add(new int[]{A,B,C});
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);


        dist[1] = 0;

        for(int i = 1; i < N ; i++){
            for(int[] next : g){
                int from = next[0];
                int to = next[1];
                int value = next[2];
                if(dist[from] != Long.MAX_VALUE && dist[from] + value < dist[to]){
                    dist[to] = dist[from] + value;
                }
            }
        }


        for(int[] next : g){
                int from = next[0];
                int to = next[1];
                int value = next[2];
                if(dist[from] != Long.MAX_VALUE && dist[from] + value < dist[to]){
                    System.out.println(-1);
                    return;
                }
            }


        for(int i = 2 ; i <= N; i++){
            if(dist[i] == Long.MAX_VALUE){
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}