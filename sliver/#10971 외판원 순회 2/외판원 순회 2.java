import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int N;
    static StringTokenizer st;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 1 ; i <= N ; i++ ){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 1 ; i <= N;i++){
            if(!visited[i]){
                visited[i] = true;
                findAnswer(1,i,String.valueOf(i),i);
                visited[i] = false;
            }
        }
        
        System.out.print(answer);
    }
    
    public static void findAnswer(int depth, int prev,String s,int start){
        if(depth == N){
            if(map[prev][start] != 0){
                int result = map[prev][start];
                
                String[] sarr = s.split(" ");
                for(int i = 0 ; i < N-1 ; i++){
                    result += map[Integer.parseInt(sarr[i])][Integer.parseInt(sarr[i+1])];
                }
                
                if(result < answer){
                    answer = result;
                }
            }         
        } else {
            for(int i = 1 ; i <= N;i++){
                if(!visited[i] && map[prev][i] != 0){
                    visited[i] = true;
                    findAnswer(depth+1,i,s+" "+String.valueOf(i),start);
                    visited[i] = false;
                }
            }
        }
        
    }
}