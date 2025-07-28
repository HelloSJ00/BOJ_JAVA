import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] arr;
    static int[] findArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        findArr = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < M ; i++){
            findArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i < M ; i++){
            if(isPresent(findArr[i])) sb.append("1");
            else sb.append("0");
            
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    public static boolean isPresent(int X){
        int s = 0;
        int e = N-1;
        
        int mid;
        while( s <= e){
            mid = (s+e)/2;
            
            if(arr[mid] > X){
                e = mid - 1;
            }else if(arr[mid] < X){
                s = mid + 1;
            } else if (arr[mid] == X ){
                return true;
            }
        }
        
        return false;
    }
}