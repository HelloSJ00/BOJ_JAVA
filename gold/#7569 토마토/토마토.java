import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] map = new int[H+1][M+1][N+1];

		for(int height = 1; height <= H ;height ++){
			for(int horizontal = 1; horizontal <= M ; horizontal++ ){
				st = new StringTokenizer(br.readLine());
				for(int vertical = 1; vertical <= N ; vertical++){
					map[height][horizontal][vertical] = Integer.parseInt(st.nextToken());
				}
			}
		}

		System.out.print(Solution(N, M, H, map));

	}

	public static int Solution(int N,int M,int H,int[][][] map){
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		int[] dz = new int[]{-1,0,0,1,0,0};
		int[] dy = new int[]{0,-1,0,0,1,0};
		int[] dx = new int[]{0,0,-1,0,0,1};

		for(int height = 1; height <= H ;height ++){
			for(int horizontal = 1; horizontal <= M ; horizontal++ ){
				for(int vertical = 1; vertical <= N ; vertical++){
					if(map[height][horizontal][vertical]==1){
						q.add(new int[]{height,horizontal,vertical});
					}
				}
			}
		}

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cur_z = cur[0];
			int cur_y = cur[1];
			int cur_x = cur[2];

			for(int i = 0 ; i<6;i++){
				int new_z = cur_z +dz[i];
				int new_y = cur_y +dy[i];
				int new_x = cur_x +dx[i];
				if ( new_z > 0 && new_z <= H &&
				new_y > 0 && new_y <= M &&
				new_x > 0 && new_x <= N &&
				map[new_z][new_y][new_x] == 0){
					map[new_z][new_y][new_x] = map[cur_z][cur_y][cur_x]+1;
					q.add(new int[]{new_z,new_y,new_x});
				}
			}
		}

		for(int height = 1; height <= H ;height ++){
			for(int horizontal = 1; horizontal <= M ; horizontal++ ){
				for(int vertical = 1; vertical <= N ; vertical++){
					if(map[height][horizontal][vertical]==0) return -1;
					else if(map[height][horizontal][vertical]-1 > answer){
						answer = map[height][horizontal][vertical]-1;
					}
				}
			}
		}

		return answer;
	}
}