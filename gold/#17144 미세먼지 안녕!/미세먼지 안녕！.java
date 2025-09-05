import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int R;
    static int C;
    static int T;
    static int[][] map ;
    static List<int[]> airCleaner = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    airCleaner.add(new int[]{i,j});
                }
            }
        }

        for(int i = 0 ; i < T ; i++){
            simulation();
        }

        int sum = 0;
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j] != -1) sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void simulation(){
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};

        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j] == 0 || map[i][j] == -1) continue;
                else q.offer(new int[]{i,j,map[i][j]});
            }
        }

        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int value = cur[2];

            int cnt =0;

            for(int i = 0 ; i < 4 ; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && ny < R && nx >= 0 && nx < C && map[ny][nx] != -1){
                    cnt++;
                    map[ny][nx] += (value/5);
                }
            }
            map[y][x] -= cnt*(value/5);
        }

        circularAir();
    }
    
    static void circularAir(){
        int[] airUp = airCleaner.get(0);
        int[] airDown = airCleaner.get(1);

        // 윗부분
        // 윗방향
        for(int i = airUp[0]-1 ; i > 0 ; i--){
            map[i][0] = map[i-1][0];
        }

        // ->>
        for(int i = 0 ; i < C-1 ; i++){
            map[0][i] = map[0][i+1];
        }

        // 아래로
        for(int i = 0 ; i < airUp[0]; i++){
            map[i][C-1] = map[i+1][C-1];
        }

        // <<--
        for(int i = C-1 ; i > 1 ; i--){
            map[airUp[0]][i] = map[airUp[0]][i-1];
        }

        map[airUp[0]][1] = 0;


        // 아래 부분
        // 아래로
        for(int i = airDown[0]+1 ; i < R-1 ; i++){
            map[i][0] = map[i+1][0];
        }

        // ->>
        for(int i = 0 ; i < C-1 ; i++){
            map[R-1][i] = map[R-1][i+1];
        }

        // 위로
        for(int i = R-1 ; i > airDown[0]; i--){
            map[i][C-1] = map[i-1][C-1];
        }

        // <<--
        for(int i = C-1 ; i > 1 ; i--){
            map[airDown[0]][i] = map[airDown[0]][i-1];
        }

        map[airDown[0]][1] = 0;
    }
}