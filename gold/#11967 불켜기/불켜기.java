import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static List<int[]>[][] l;
    static boolean[][] turnUp;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        l = new ArrayList[N+1][M+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                l[i][j] = new ArrayList<>();
            }
        }
        turnUp = new boolean[N+1][M+1];
        turnUp[1][1] = true;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l[x][y].add(new int[]{a,b});
        }

        while(turnUpLightFromStart() > 0);

        int ans = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(turnUp[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }

    static int turnUpLightFromStart(){
        int cnt = 0;
        boolean[][] visit = new boolean[N+1][M+1];

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,1});
        visit[1][1] = true;

        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int[] nextLight : l[cy][cx]){
                if(!turnUp[nextLight[0]][nextLight[1]]){
                    turnUp[nextLight[0]][nextLight[1]] = true;
                    cnt++;
                }
            }

            for(int i = 0 ; i < 4 ; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny > 0 && ny <= N && nx > 0 && nx <= M && !visit[ny][nx] && turnUp[ny][nx]){
                    q.offer(new int[]{ny,nx});
                    visit[ny][nx] = true;
                }
            }
        }
        return cnt;
    }
}