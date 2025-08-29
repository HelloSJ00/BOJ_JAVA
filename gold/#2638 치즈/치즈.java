import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] cheese;
    static Deque<int[]> q = new ArrayDeque<>();
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};
    static int time = 0;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j = 0 ; j < M ; j++){
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 실온 만들기
        q.offer(new int[]{0,0});
        cheese[0][0] = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny >= 0 && nx >= 0 && ny < N && nx < M && cheese[ny][nx] == 0){
                    cheese[ny][nx] = -1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                //치즈면 좌표, 시간
                if(cheese[i][j] == 1 && howRoundAir(i,j) >= 2) q.offer(new int[]{i,j});
            }
        }


        // 다음에 녹는 애들만 큐에 넣고 녹이고 공기 순환
        while(true){
            // System.out.println("___");
            // for(int i = 0; i < N ; i++){
                
            //     System.out.println(Arrays.toString(cheese[i]));
            // }
            // 녹이고 순환
            boolean tmp = melting();
            if(!tmp){
                break;
            }
        }

        System.out.println(time);

    }

    static int howRoundAir(int y,int x){
        int cnt = 0;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < N && nx >= 0 && nx <M && cheese[ny][nx] == -1) cnt++;
        }

        return cnt;
    }

    static void air(int y , int x){
        Deque<int[]> qq = new ArrayDeque<>();
        qq.offer(new int[]{y,x});

        while(!qq.isEmpty()){
            int[] cur = qq.poll();

            for(int i = 0 ; i < 4 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if( ny >= 0 && ny < N && nx >= 0 && nx <M && cheese[ny][nx] == 0){
                    cheese[ny][nx] = -1;
                    qq.offer(new int[]{ny,nx});
                }
            }
        }
    }

    static boolean melting(){
        if(q.size() == 0) return false;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            cheese[cur[0]][cur[1]] = -1;
            air(cur[0],cur[1]);
        }

        time++;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                //치즈면 좌표, 시간
                if(cheese[i][j] == 1 && howRoundAir(i,j) >= 2) q.offer(new int[]{i,j});
            }
        }
        return true;
    }
}