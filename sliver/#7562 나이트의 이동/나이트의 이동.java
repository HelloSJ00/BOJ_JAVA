import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int TC;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        TC = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < TC ; i++){
            sb.append(f()+"\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static int f() throws Exception{
        int I = Integer.parseInt(br.readLine());
   
        board = new int[I][I];
        for(int i = 0 ; i < I ; i ++){
            for(int j = 0 ; j < I ; j++){
                board[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        int[] start = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        
        st = new StringTokenizer(br.readLine());
        int[] end = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        
        int move = 0;
        q.add(new int[]{start[0],start[1],0});
        board[start[0]][start[1]] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int[] dy = new int[]{-1,-2,-2,-1,1,2,2,1};
            int[] dx = new int[]{-2,-1,1,2,2,1,-1,-2};
            
            for(int i = 0 ; i < 8 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= 0 && ny < I && nx >= 0 && nx < I &&
                  cur[2]+1 < board[ny][nx]){
                    board[ny][nx] = cur[2]+1;
                    q.add(new int[]{ny,nx,board[ny][nx]});
                }
            }
            
        }
        
        return board[end[0]][end[1]] ;
    }
}