import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] visit;
    static String[][] map;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N][M][2];
        map = new String[N][M];
        for(int i = 0 ; i < N ; i++){
            map[i] = br.readLine().split("");
        }
        
        Set<int[]> set = new HashSet<>();
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!set.contains(visit[i][j])){
                    set.add(visit[i][j]);
                    if(bfs(i,j)){
                        System.out.print("Yes");
                        return;
                    }
                }
            }
        }
        System.out.print("No");
    }
    
    public static boolean bfs(int y ,int x){
        String cs = map[y][x];
        visit[y][x] = new int[]{y,x};
        
        int[] dy = {0,-1,0,1};
        int[] dx = {-1,0,1,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,y,x});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny >= 0 && ny < N && nx >=0 && nx < M
                   && map[ny][nx].equals(cs)){
                    
                    if(ny == cur[2] && nx == cur[3]){
                        continue;
                    } else if(visit[ny][nx] == visit[y][x]) return true;
                    else {
                        q.add(new int[]{ny,nx,cur[0],cur[1]});
                        visit[ny][nx] = visit[y][x];
                    }
                }
            }
        }
        return false;
        
    }
}