import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i++){
            String[] st = br.readLine().split("");

            for(int j = 1 ; j <= M ; j++){
                arr[i][j] = Integer.parseInt(st[j-1]);
            }
        }

        int max = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                int cur = arr[i][j];

                if(cur == 0) continue;
                max = Math.max(1,max);
                if(
                    arr[i-1][j] >= cur &&
                    arr[i][j-1] >= cur &&
                    arr[i-1][j-1] >= cur ){
                    int tmp = 1;
                    int min = Math.min(Math.min(arr[i-1][j],arr[i][j-1]),arr[i-1][j-1]);
                    while(Math.pow(tmp,2) <= min) tmp++;
                    cur = (int)Math.pow(tmp,2);
                    
                    arr[i][j] = cur;
                    max = Math.max(cur,max);
                    }

                }
            }

        // for(int i = 0 ; i <= N ; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        System.out.print(max);
        }
    }