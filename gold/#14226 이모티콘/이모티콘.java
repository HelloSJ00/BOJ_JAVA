import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        arr = new int[2001][2001];
        for(int i = 1 ; i <= 2000 ; i++ ){
            for(int j = 1; j <= 2000 ; j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        getAns();
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i < 1001 ; i++){
            ans = Math.min(ans,arr[N][i]);
        }
        System.out.print(ans);

        // for(int i = 0 ; i < 1001 ; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
    }
    
    public static void getAns(){
        Queue<int[]> pq = new LinkedList<>();
        // 현재 노드 위치, 연산횟수 , 클립보드
        pq.add(new int[]{1,1,1});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int cnt = cur[1];
            int clip = cur[2];
            
            // 복사
            if(curNode > clip){
                // System.out.println("복사 : " + curNode);
                pq.add(new int[]{curNode,cnt+1,curNode});
            }
            
            // 하나빼기
            int nextNode = curNode - 1;
            if(nextNode > 0 && nextNode <= 1000 && cnt + 1 < arr[nextNode][clip]){
                // System.out.println("하나빼기 : " + (curNode-1));
                arr[nextNode][clip] = cnt+1;
                pq.add(new int[]{nextNode,cnt+1,clip});
            }
            
            // 붙혀넣기
            nextNode = curNode + clip;
            if(nextNode > 0 && nextNode <= 1000 && cnt + 1 < arr[nextNode][clip]){
                // System.out.println("붙혀넣기 : " + (curNode+clip));
                arr[nextNode][clip] = cnt+1;
                pq.add(new int[]{nextNode,cnt+1,clip});
            }
        }
    }
}