import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int C;
    static int[][] map;
    static int[][] distance;
    static int[] s;
    static int[] e;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        distance = new int[R][C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0 ; i < R ; i++){
            String[] tmp = br.readLine().split("");
            for(int j = 0 ; j < C ; j++){
                if(tmp[j].equals("S")){
                    map[i][j] = 0;
                } else if(tmp[j].equals(".")){
                    map[i][j] = 1;
                } else if(tmp[j].equals("*")){
                    map[i][j] = 2;
                } else if(tmp[j].equals("X")){
                    map[i][j] = 3;
                } else if(tmp[j].equals("D")){
                    map[i][j] = 4;
                }
            }
        }
        
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j]==0){
                    s = new int[]{i,j};
                } else if(map[i][j]==4){
                    e = new int[]{i,j};
                }
            }
        }
        
        if(isArrived()) System.out.print(distance[e[0]][e[1]]);
        else System.out.print("KAKTUS");
    }
    
    public static boolean isArrived(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s[0],s[1],0});
        distance[s[0]][s[1]] = 0;
        
        while(!q.isEmpty()){
            int tmpSize = q.size();
            
            waterMove();
            
            for(int k = 0 ; k < tmpSize ; k++){
                int[] cur = q.poll();
                int[] dy = {-1,0,1,0};
                int[] dx = {0,-1,0,1};
            
                for(int i = 0 ; i < 4 ; i++){
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];
                
                    if(ny >= 0 && ny < R && nx >= 0 && nx < C &&
                       map[ny][nx]!=2 &&
                       map[ny][nx]!=3 &&
                       distance[ny][nx] > distance[cur[0]][cur[1]] +1
                      ){
                        distance[ny][nx] = distance[cur[0]][cur[1]] +1;
                        q.add(new int[]{ny,nx,distance[cur[0]][cur[1]] +1});
                    }
                }
            }
            
        }
        
        if(distance[e[0]][e[1]]==Integer.MAX_VALUE) return false;
        else return true;
        
        
    }
    
    public static void waterMove(){
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int[] dy = {-1,0,1,0};
            int[] dx = {0,-1,0,1};
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= 0 && ny < R && nx >= 0 && nx < C && map[ny][nx] == 1){
                    map[ny][nx] = 2;
                }
            }
        }
    }
}