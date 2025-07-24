import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static StringTokenizer st;
    static String[][] map;
    static int[][] dist;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new String[M][N];
        dist = new int[M][N];
        
        for(int i = 0 ; i < M ; i++){
            map[i] = br.readLine().split("");
        }
        
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = 0;
        q.add(new int[]{0,0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            int curCnt = cur[2];
            
            int[] dy = {-1,0,1,0};
            int[] dx = {0,-1,0,1};
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && ny < M && nx >= 0 && nx < N){
                    if(map[ny][nx].equals("1") && dist[ny][nx] > curCnt+1){
                        dist[ny][nx] = curCnt+1;
                        q.add(new int[]{ny,nx,curCnt+1});
                    } else if(map[ny][nx].equals("0") && dist[ny][nx] > curCnt){
                        dist[ny][nx] = curCnt;
                        q.add(new int[]{ny,nx,curCnt});
                    }
                }
                    
            }
        }
        
        System.out.print(dist[M-1][N-1]);
    }
}