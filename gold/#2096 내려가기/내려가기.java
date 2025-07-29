import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static long[][] maxDp;
    static long[][] minDp;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        maxDp = new long[N][3];
        minDp = new long[N][3];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0 ; i < 3 ; i++){
            maxDp[0][i] = map[0][i];
            minDp[0][i] = map[0][i];
        }
        
        for(int i = 1 ; i < N ; i++){
            maxDp[i][0] = Math.max(maxDp[i-1][0],maxDp[i-1][1]) + map[i][0];
            maxDp[i][1] = Math.max(maxDp[i-1][0],Math.max(maxDp[i-1][1],maxDp[i-1][2])) + map[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1],maxDp[i-1][2]) + map[i][2];
            
            minDp[i][0] = Math.min(minDp[i-1][0],minDp[i-1][1]) + map[i][0];
            minDp[i][1] = Math.min(minDp[i-1][0],Math.min(minDp[i-1][1],minDp[i-1][2])) + map[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1],minDp[i-1][2]) + map[i][2];
        }
        
        long max = 0;
        long min = Long.MAX_VALUE;
        
        for(int i = 0 ; i < 3 ; i++){
            max = Math.max(max,maxDp[N-1][i]);
            min = Math.min(min,minDp[N-1][i]);
        }
        
        System.out.print(max+" "+min);
    }
}