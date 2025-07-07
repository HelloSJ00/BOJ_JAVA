import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        for(int i = 1 ; i < N + 1 ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1 ; i < N+1 ; i++){
            findMaxValue(i+arr[i][0],arr[i][1]);
        }
        
        System.out.print(max);
    }
    
    public static void findMaxValue(int cur,int curValue){
        if(cur == N+1){
            max = Math.max(curValue,max);
            return;
        } else if(cur <= N){
            for(int i = cur ; i < N+1 ; i++ ){
                if(i+arr[i][0] <= N+1){
                   findMaxValue(i+arr[i][0],curValue+arr[i][1]); 
                } else {
                   findMaxValue(N+1,curValue);
                }
            }
        }
    }
}