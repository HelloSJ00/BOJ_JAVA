import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 1 ; i <= (N/2) +1 ; i++){
            visited[i] = true;
            devideTeam(1,i);
            visited[i] = false;
        }
        
        System.out.print(result);
        
    }
    
    public static void devideTeam(int num,int prevIdx){
        if(num == (N/2)){
            result = Math.min(result,calcDiff());
            return;
        } else {
            for(int i = prevIdx +1 ; i <= N ; i++ ){
                if(!visited[i]){
                    visited[i] = true;
                    devideTeam(num+1,i);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static int calcDiff(){
        int a=0;
        int b=0;
        
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(visited[i] && (visited[i] == visited[j])){
                    a += map[i][j];
                } else if (!visited[i] && (visited[i] == visited[j])){
                    b += map[i][j];
                }
            }
        }
        
        return a-b > 0 ? a-b : b-a;
    }
}