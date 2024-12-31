import java.io.*;
import java.util.*;

public class Main{
	static LinkedList<Integer> count = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N+1][N+1];


		for(int i = 1 ; i <= N;i ++){
			String[] input = br.readLine().split("");
			for(int j = 1;j<=N;j++){
				// 문자열로 받은 입력값 정수형으로 바꿔주기
				map[i][j] = Integer.parseInt(input[j-1]);
			}
		}

		Solution(map,N);

		Collections.sort(count);
		StringBuilder sb = new StringBuilder();
		sb.append(count.size()).append('\n');
		for(int i = 0; i<count.size();i ++){
			sb.append(count.get(i)).append('\n');
		}

		System.out.print(sb);
	}

	public static void Solution(int[][] map, int N){
		int[][] visit = new int[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		int[] dy = new int[]{0,-1,0,1};
		int[] dx = new int[]{-1,0,1,0};

		for (int y = 1; y <= N;y ++){
			for (int x = 1 ; x <= N; x ++){
				if (map[y][x] == 1 && visit[y][x] == 0){
					visit[y][x] = 1;
					int tmp_cnt = 1;
					q.add(new int[]{y,x});

					while(!q.isEmpty()){
						int[] cur = q.poll();
						int cur_y = cur[0];
						int cur_x = cur[1];
						for (int i = 0; i< 4 ; i++){
							int new_y = cur_y + dy[i];
							int new_x = cur_x + dx[i];
							if ( 0 < new_y && new_y <= N &&
										0 < new_x && new_x <= N &&
										map[new_y][new_x] == 1 &&
										visit[new_y][new_x] == 0){
											tmp_cnt ++;
											visit[new_y][new_x] = 1;
											q.add(new int[]{new_y,new_x});
										}
						}
					}
					count.add(tmp_cnt);
				}
			}
		}
		
		
	}
}