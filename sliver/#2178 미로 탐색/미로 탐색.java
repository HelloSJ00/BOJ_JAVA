import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+1][M+1];
		for (int i = 1; i< N+1 ;i++){
			String[] tmp = bf.readLine().split("");
			for(int j = 1 ; j < M+1;j++){
				map[i][j] = Integer.parseInt(tmp[j-1]);
			}
		}
		System.out.print(Solution(map,N,M));
	}

	public static int Solution(int[][] map,int N,int M){
		int[][] visit = new int[N+1][M+1];
		visit[1][1] =1;

		// 탐색 위한 자료구조 선정
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{1,1});

		// 바둑판 배열 이동 위한 배열
		int[] dx = new int[]{0,-1,0,1};
		int[] dy = new int[]{-1,0,1,0};

		/*
		 * 시작점 큐에 넣고 시작
		 */
		while(!queue.isEmpty()){
			
			int[] cur = queue.poll();
			int cur_y = cur[0];
			int cur_x = cur[1];
			// System.out.println("이번 풀은" + cur_y + ',' + cur_x );
			for(int i = 0;i < 4;i++){
				int next_y = cur_y + dy[i];
				int next_x = cur_x + dx[i];
				if (0 < next_y && next_y < N+1 && 
						0 < next_x && next_x < M+1 &&
						map[next_y][next_x] == 1 &&
						visit[next_y][next_x] == 0){
							queue.add(new int[]{next_y,next_x});
							visit[next_y][next_x] = visit[cur_y][cur_x] +1;
					}
			}
			
		}
		return visit[N][M];
	}
}