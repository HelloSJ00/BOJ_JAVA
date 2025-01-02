import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] tomatos = new int[M+1][N+1];

		for(int i = 1; i<= M ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N ;j++ ){
				tomatos[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(Solution(M,N,tomatos));
	}

	public static int Solution(int M,int N,int[][] tomatos){
		// int[][] visit = new int[M+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		int[] dy = new int[]{0,-1,0,1};
		int[] dx = new int[]{-1,0,1,0};
		int answer = 0;

		for(int i = 1 ; i <= M ; i++){
			for (int j = 1 ; j <= N ; j++){
				if(tomatos[i][j] == 1){
					q.add(new int[]{i,j});
				}
			}
		}

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cur_y = cur[0];
			int cur_x = cur[1];
			int cur_cnt = tomatos[cur_y][cur_x];

			for(int i = 0 ;i < 4 ; i++){
				int new_y = cur_y + dy[i];
				int new_x = cur_x + dx[i];
				if (0 < new_y && new_y <= M && 0 < new_x && new_x <= N &&
					tomatos[new_y][new_x] == 0){
						tomatos[new_y][new_x] = cur_cnt +1;
						q.add(new int[]{new_y,new_x});
				}
			}
		}

		for(int i = 1 ; i <= M ; i++){
			for (int j = 1 ; j <= N ; j++){
				if (tomatos[i][j] == 0){
					return -1;
				} else if(tomatos[i][j]-1 > answer ){
					answer = tomatos[i][j]-1;
				}
			}
		}
		if (answer == 0) return 0;
		else return answer;
	}
}