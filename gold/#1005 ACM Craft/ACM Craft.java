import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int TC;
    static int N;
    static int K;
    static int W;
    static int[] parentNum;
    static int[] build;
    static int[] time;
    static List<List<Integer>> g;
    public static void main(String[] args) throws Exception{
        TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC ; i++){
            g = new ArrayList<>();
            getTime();
        }

        System.out.println(sb.toString());
    }

    static void getTime() throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parentNum = new int[N+1];
        build = new int[N+1];
        time = new int[N+1];

        for(int i = 0 ; i <= N ; i++){
            g.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            build[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            g.get(X).add(Y);
            
            // Y의 부모 개수를 ++
            parentNum[Y]++;
        }
        
        W = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[2]));
        for(int i = 1 ; i <= N ; i++){
            if(parentNum[i] == 0){
                // 출발지점 , 도착 지점 , 소요시간 
                pq.offer(new int[]{0,i,0});
            }
        }

        // System.out.println("build -> : "+ Arrays.toString(build));
        while(!pq.isEmpty()){
            // System.out.println(Arrays.toString(time));
            int[] cur = pq.poll();
            int from = cur[0];
            int to = cur[1];
            int curTime = cur[2];

            // System.out.println(Arrays.toString(cur));
            if(parentNum[to] > 1){
                parentNum[to]--;
                time[to] = Math.max(curTime,time[to]);
                continue;
            }

            if(to == W){
                int result = Math.max(time[to],curTime) + build[to];
                sb.append(result).append("\n");
                return;
            }

            for(int next : g.get(to)){
                pq.offer(new int[]{to,next,curTime+build[to]});
            }
        }
    }
}