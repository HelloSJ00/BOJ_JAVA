import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    // 몇번만에 갔는지, 부모가 누군지
    static int[][] road = new int[100001][2];
    static StringTokenizer st;
    static int ans;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        
        for(int i = 0 ; i < 100001 ; i ++){
            road[i] = new int[]{Integer.MAX_VALUE,-1};
        }
        road[N] = new int[]{0,-1};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[0]));
        //  연산횟수,현재 노드,부모 노드
        pq.add(new int[]{0,N});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cnt = cur[0];
            int curNode = cur[1];
            
            if(cnt >= road[K][0]){
                continue;
            }

            int nextNode = curNode - 1;
            if((nextNode >= 0 && nextNode <= 100000) && road[nextNode][0] > cnt + 1){
                road[nextNode] = new int[]{cnt+1,curNode};
                pq.add(new int[]{cnt+1,nextNode});
            }
            
            nextNode = curNode + 1;
            if((nextNode >= 0 && nextNode <= 100000) && road[nextNode][0] > cnt + 1  ){
                road[nextNode] = new int[]{cnt+1,curNode};
                pq.add(new int[]{cnt+1,nextNode});
            }
            
            nextNode = curNode * 2;
            if((nextNode >= 0 && nextNode <= 100000) && road[nextNode][0] > cnt + 1){
                road[nextNode] = new int[]{cnt+1,curNode};
                pq.add(new int[]{cnt+1,nextNode});
            }
        }
        int numOfStep = road[K][0];
        System.out.println(numOfStep);
        
        int[] result = new int[numOfStep+1];
        int cur = K;
        for(int i = numOfStep ; i >= 0 ; i--){
            result[i] = cur;
            
            cur = road[cur][1];
        }
        
        for(int i = 0 ; i <= numOfStep ; i++){
            System.out.print(result[i] + " ");
        }
    }
    
}