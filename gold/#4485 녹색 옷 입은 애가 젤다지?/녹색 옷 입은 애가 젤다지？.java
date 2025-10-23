import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringTokenizer st;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};

	public static void main(String[] args) throws Exception{
		int cnt = 0;
		while(true){
			cnt++;
			N = Integer.parseInt(br.readLine());
			if(N==0) break;

			int[][] map = new int[N][N];

			for(int i = 0 ; i < N ; i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] distance = new int[N][N];
			for(int i = 0 ; i < N ; i++){
				Arrays.fill(distance[i],Integer.MAX_VALUE);
			}
			distance[0][0] = map[0][0];

			Deque<int[]> q = new ArrayDeque<>();
			q.offer(new int[]{0,0,map[0][0]});

			while(!q.isEmpty()){
				int[] cur = q.poll();
				// System.out.println(Arrays.toString(cur));
				for(int i = 0 ; i < 4 ; i++){
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if(ny >= 0 && ny < N && nx >= 0 && nx < N &&
						cur[2] + map[ny][nx] < distance[ny][nx]
					){
						distance[ny][nx] = cur[2] + map[ny][nx];
						q.offer(new int[]{ny,nx,distance[ny][nx]});
					}
				}
			}

			System.out.println("Problem " + cnt +": "+distance[N-1][N-1]);
		}
	}

}