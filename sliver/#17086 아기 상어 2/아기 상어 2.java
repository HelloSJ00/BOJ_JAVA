import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.<int[]>comparingInt(a->a[1]));
	static int[][] move = {
		{0,1},
		{0,-1},
		{1,0},
		{-1,0},
		{1,1},
		{1,-1},
		{-1,1},
		{-1,-1}
	};
	static public void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		for(int i = 0 ; i < N ; i++){
			Arrays.fill(dist[i],Integer.MAX_VALUE);
		}

		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 1){
					pq.offer(new int[]{i,j,0});
					dist[i][j] = 0;
				}
			}
		}


		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			// System.out.println(Arrays.toString(cur));

			int cy = cur[0];
			int cx = cur[1];
			int curDist = cur[2];

			if(curDist > dist[cy][cx]) continue;

			for(int[] m : move){
				int ny = cy + m[0];
				int nx = cx + m[1];

				if(ny >= 0 && ny < N && nx >=0 && nx < M && curDist+1 < dist[ny][nx] && map[ny][nx] != 1){
					dist[ny][nx] = curDist+1;
					pq.offer(new int[]{ny,nx,dist[ny][nx]});
				}
			}
		}
		int answer = 0;

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < M ; j++){
				answer = Math.max(answer,dist[i][j]);
			}
		}

		// for(int i = 0 ; i < N ; i++){
		// 	System.out.println(Arrays.toString(dist[i]));
		// }
		System.out.println(answer);
	}
}