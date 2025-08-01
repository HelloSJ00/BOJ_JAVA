import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] + Integer.parseInt(st.nextToken())-arr[i-1][j-1];
            }
        }
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            sb.append(arr[y2][x2] - arr[y2][x1-1] - arr[y1-1][x2] + arr[y1-1][x1-1]+"\n");
        }
        
        System.out.print(sb.toString());
    }
}