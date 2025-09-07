import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] map;
    static int[] babyShark = new int[2];
    static int sharkSize = 2;
    static int howManyEat = 2;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        // 입력
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    babyShark = new int[]{i,j};
                    map[i][j] = 0;
                }
            }
        }

        while(findCanEatFishWhere());
        System.out.println(ans);
    }

    static boolean findCanEatFishWhere(){
        int[] dy = {-1,0,1,0};
        int[] dx = {0,-1,0,1};
        int[][] dist = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[2]));
        pq1.offer(new int[]{babyShark[0],babyShark[1],0});
        dist[babyShark[0]][babyShark[1]] = 0;

        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[2])
                                                    .thenComparingInt(a->a[0])
                                                    .thenComparingInt(a->a[1]));

        while(!pq1.isEmpty()){
            int[] cur = pq1.poll();
            // System.out.println(Arrays.toString(cur));
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < N && dist[ny][nx] > cnt+1){
                    dist[ny][nx] = cnt+1;

                    if(map[ny][nx] == 0 || map[ny][nx] == sharkSize){
                        pq1.offer(new int[]{ny,nx,cnt+1});
                    } else if(sharkSize > map[ny][nx]){
                        pq2.offer(new int[]{ny,nx,cnt+1});
                    }
                }
            }
        }

        if(pq2.isEmpty()){
            return false;
        } else {
            int[] next = pq2.poll();

            map[next[0]][next[1]] = 0;

            howManyEat--;
            if(howManyEat == 0){
                sharkSize++;
                howManyEat = sharkSize;
            }

            babyShark[0] = next[0];
            babyShark[1] = next[1];

            ans += next[2];
            return true;
        }
    }
}