import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static int[] arr = new int[100001];
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i <= 100000 ; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N,0});
        arr[N] = 0;
        int nextNode;
            
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curNode = cur[0];
            int curCnt = cur[1];
            
            
            nextNode = curNode - 1;
            if(nextNode >= 0 && nextNode <= 100000
              && arr[nextNode] > curCnt+1){
                arr[nextNode] =curCnt+1;
                q.add(new int[]{nextNode,curCnt+1});
            }
            
            nextNode = curNode + 1;
            if(nextNode >= 0 && nextNode <= 100000
              && arr[nextNode] > curCnt+1){
                arr[nextNode] =curCnt+1;
                q.add(new int[]{nextNode,curCnt+1});
            }
            
            nextNode = curNode*2;
            if(nextNode >= 0 && nextNode <= 100000
              && arr[nextNode] > curCnt){
                arr[nextNode] = curCnt;
                q.add(new int[]{nextNode,curCnt});
            }
                
        }
        
        System.out.print(arr[K]);
    }
}