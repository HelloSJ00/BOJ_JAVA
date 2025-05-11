import java.io.*;
import java.util.*;

public class Main{
    static int N = 0;
    static int length = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        int[] arr = new int[length+1];
        bt(arr,1);
    }
    
    public static void bt(int[] arr,int depth){
        if(depth == length+1){
            for(int i = 1 ; i <= length ; i++){
                
                if(i == length){
                    System.out.println(arr[i]);
                }
                else {
                    System.out.print(arr[i]+" ");
                }
            }
            return;
        }
        
        for(int i = 1 ; i <= N ; i++){
            boolean isCan = true;
            for(int j = 1; j < depth ; j++){
                if(arr[j] == i){
                    isCan = false;
                    break;
                }
            }
            if(isCan){
                arr[depth] = i;
                bt(arr,depth+1);
                arr[depth] = 0;
            }
        }
        
    }
}