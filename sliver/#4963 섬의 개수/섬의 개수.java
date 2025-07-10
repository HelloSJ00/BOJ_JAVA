import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int W;
    static int H;
    static String[][] map;
    static boolean[][] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        while(true){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if( W== 0 && H ==0) return;
            
            map = new String[H][W];
            visited = new boolean[H][W];
            for(int i = 0 ; i < H ; i++){
                map[i] = br.readLine().split(" ");
            }
            
            System.out.println(findIsland());
        }
    }
    public static int findIsland(){
        int result = 0;
        
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < W ; j++){
                if(map[i][j].equals("1") && !visited[i][j]){
                    result++;
                    bfs(i,j);
                }
            }
        }
        
        return result;
    }
    
    public static void bfs(int a,int b){
        int[] dy = {-1,0,1,0,-1,-1,1,1};
        int[] dx = {0,-1,0,1,-1,1,-1,1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            visited[cy][cx] = true;
            
            for(int i = 0 ; i < 8 ; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && ny < H && nx >=0 && nx < W &&
                  !visited[ny][nx] && map[ny][nx].equals("1")
                  ){
                    q.add(new int[]{ny,nx});
                    visited[ny][nx]=true;
                }
            }
        }
       
    }
}