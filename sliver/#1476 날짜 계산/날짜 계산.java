import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = 15*29*19;
        for(int i = 1 ; i <= K ; i++){
            if(
                (i-arr[0])%15 == 0 && 
                (i - arr[1])%28 == 0 && 
                (i-arr[2])%19 == 0 
                ){
                    System.out.println(i);
                    break;
                }
        }
        
    }
}