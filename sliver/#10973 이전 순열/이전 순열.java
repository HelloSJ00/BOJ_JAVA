import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st ;
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        findPrev();
    }
    
    public static void findPrev(){
        int i = N;
        
        while(i > 1 && arr[i-1] < arr[i]){
            i--;
        }
        
        if(i == 1) {
            System.out.print("-1");
            return;
        }
        
        int swap_num = N;
        while(arr[swap_num] > arr[i-1]){
            swap_num--;
        }
        
        swap(i-1,swap_num);
        
        sort_reverse(i,N);
        
        for(int j = 1 ; j <= N ; j++){
            sb.append(arr[j] + " ");
        }
        
        System.out.print(sb.toString().trim());
    }
    
    public static void swap(int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    public static void sort_reverse(int a,int b){
        while(a<b){
            swap(a,b);
            a++;
            b--;
        }
    }
}