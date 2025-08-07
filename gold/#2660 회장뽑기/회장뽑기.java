import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<int[]> edges = new ArrayList<>();
    static int[][] g;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==-1 && b == -1) break;
            edges.add(new int[]{a,b});
        }

        g = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(i==j) g[i][j] = 0;
                else{
                g[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];

            g[a][b] = 1;
            g[b][a] = 1;
        }



        for(int k = 1 ; k <= N ; k++){
            for(int i = 1; i <= N ; i++){
                for(int j = 1; j <= N ; j++){
                    if(g[i][k] != Integer.MAX_VALUE && g[k][j] != Integer.MAX_VALUE){
                        g[i][j] = Math.min(g[i][j],g[i][k]+g[k][j]);
                    }
                }
            }
        }

        // for(int i = 1 ; i <= N ; i++){
        //     System.out.println(Arrays.toString(g[i]));
        // }

        int[] sum = new int[N+1];

        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N;i++){
            for(int j = 1; j <= N ; j++){
                sum[i] = Math.max(g[i][j],sum[i]);
            }
            min = Math.min(sum[i],min);
        }

        // System.out.println(Arrays.toString(sum));
        // System.out.println(min);

        int cnt = 0;
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= N ; i++){
            if(sum[i] == min) {
                cnt++;
                l.add(i);
            }
        }

        System.out.println(min+" "+cnt);
        for(int i : l){
            System.out.print(i+" ");
        }
    }
}