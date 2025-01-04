import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());

				int[][] map = new int[N+1][M+1];
				int[] startVertex = new int[]{0,0};

				for(int i = 1 ; i <= N ; i++){
					st = new StringTokenizer(br.readLine());
					for (int j = 1; j <= M ;j++){
						int tmp = Integer.parseInt(st.nextToken());
						map[i][j] = tmp;

						if(tmp == 2){
							startVertex = new int[]{i,j};
						}
					}
				}

				Solution(map,startVertex,N,M);

				
    }

    public static void Solution(int[][] map,int[] start,int N,int M) {
      int[][] distance = new int[N+1][M+1];
			for(int i = 1 ; i <= N ; i++){
				for (int j = 1; j <= M ;j++){
					if(map[i][j] ==1){
						distance[i][j] = Integer.MAX_VALUE;
					} else {
						distance[i][j] = 0;
					}
				}
			}
			int[] dy = new int[]{-1,0,1,0};
			int[] dx = new int[]{0,-1,0,1};

			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2])); 
			pq.add(new int[]{start[0],start[1],0});

			while(!pq.isEmpty()){
				int[] cur = pq.poll();
				int cur_y = cur[0];
				int cur_x = cur[1];
				int cur_cnt = cur[2];

				for(int i = 0 ; i < 4 ; i++){
					int new_y = cur_y + dy[i];
					int new_x = cur_x + dx[i];
					if (new_y > 0 && new_y <= N && new_x > 0 && new_x <= M &&
					map[new_y][new_x] == 1 && distance[new_y][new_x] > cur_cnt+1){
						pq.add(new int[]{new_y,new_x,cur_cnt+1});
						distance[new_y][new_x] = cur_cnt+1;
					}
				}
			}

			for(int i = 1 ; i <= N ; i++){
				for (int j = 1; j <= M ;j++){
					if(distance[i][j] == Integer.MAX_VALUE){
						distance[i][j] = -1;
					} 
					}
				}

			StringBuilder sb = new StringBuilder();
			for(int i = 1 ; i <= N ; i++){
				for (int j = 1; j <= M ;j++){
					sb.append(distance[i][j]).append(' ');
				}
				sb.append('\n');
			}

			System.out.print(sb);
    }
}
