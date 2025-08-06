import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> g = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static long[][] dist;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        dist = new long[N+1][N+1];

        for(int i = 0 ; i <= N ; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        for(int i = 1; i <= N ; i++){
            for(int j = 1; j <= N ; j++){
                if(i==j){
                    dist[i][j] = 0;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b],c);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N ; j++){
                for(int k = 1; k <= N ; k++){
                    if(dist[j][i] != Long.MAX_VALUE && dist[i][k] != Long.MAX_VALUE){
                        dist[j][k] = Math.min(dist[j][k],dist[j][i] + dist[i][k]);
                    }
                }
            }
        }

        for(int i = 1 ; i <= N; i++){
            for(int j = 1; j <= N ; j++){
                if(dist[i][j] == Long.MAX_VALUE){
                    sb.append(0).append(" ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}