import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] map;
    static int[][][] dist;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        dist = new int[N][M][2];
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                dist[i][j][0] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < s.length() ; j++){
                if(s.charAt(j) == '0'){
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }

            // System.out.println(Arrays.toString(map[i]));
        }


        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[2]));
        // y,x,dist,벽 부쉈는지
        pq.offer(new int[]{0,0,1,0});
        dist[0][0] = new int[]{1,1};
        
        int[] dy = {0,-1,0,1};
        int[] dx = {-1,0,1,0};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            // System.out.println(Arrays.toString(cur));
            int cy = cur[0];
            int cx = cur[1];
            int cDist = cur[2];
            int wall = cur[3];

            if(wall == 1){
                // 이미 벽부숨
                for(int i = 0 ; i < 4 ; i++){
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if(ny >= 0 && ny < N && nx >= 0 && nx < M &&
                        map[ny][nx] == 0 && 
                        dist[ny][nx][1] > cDist+1
                    ){
                        dist[ny][nx][1] = cDist+1;
                        pq.offer(new int[]{ny,nx,cDist+1,wall});
                    }
                }
            } else {
                for(int i = 0 ; i < 4 ; i++){
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if(ny >= 0 && ny < N && nx >= 0 && nx < M
                    ){
                        if(map[ny][nx] == 1 && dist[ny][nx][1] > cDist+1){
                            dist[ny][nx][1] = cDist+1;
                            pq.offer(new int[]{ny,nx,cDist+1,1});
                        } else if(map[ny][nx] == 0 && dist[ny][nx][0] > cDist+1){
                            dist[ny][nx][0] = cDist+1;
                            pq.offer(new int[]{ny,nx,cDist+1,0});
                        }
                    }
                }
            }
        }

        // for(int i = 0 ; i < N ; i++){
        //     for(int j = 0 ; j < M ; j++){
        //         System.out.print(Arrays.toString(dist[i][j]));
        //     }
        //     System.out.println();
        // }

        if(Math.min(dist[N-1][M-1][0],dist[N-1][M-1][1]) == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        } 
        System.out.println(Math.min(dist[N-1][M-1][0],dist[N-1][M-1][1]));
    }
}