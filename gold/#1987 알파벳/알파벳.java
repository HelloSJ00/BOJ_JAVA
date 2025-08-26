import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int C;
    static String[][] board;
    static Set<String> set = new HashSet<>();
    static StringTokenizer st;
    static int ans = 0;
    static Deque<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];

        for(int i = 0 ; i < R ; i++){
            board[i] = br.readLine().split("");
        }

        
        set.add(board[0][0]);
        dfs(0,0,1);

        System.out.println(ans);
    }

    static void dfs(int y,int x, int cnt){
        ans = Math.max(cnt,ans);
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};

        for(int i = 0 ; i < 4 ; i ++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < R && nx >= 0 && nx < C && !set.contains(board[ny][nx]) 
            ){
                set.add(board[ny][nx]);
                dfs(ny,nx,cnt+1);
                set.remove(board[ny][nx]);
            }
        }
    }
}