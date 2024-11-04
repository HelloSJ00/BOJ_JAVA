import java.io.*;
import java.util.*;
import java.util.Queue;
import java.awt.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(st.nextToken());

		for(int i = 0;i<testCase;i++){
			// System.out.println("테스트 시작");
			st = new StringTokenizer(br.readLine());
			int max_y= Integer.parseInt(st.nextToken());
			int max_x = Integer.parseInt(st.nextToken());
			int[][] visit = new int[max_y][max_x];
			int[][] baechuBat = new int[max_y][max_x];
			for(int cur_y = 0;cur_y<max_y;cur_y++){
				for(int cur_x=0;cur_x<max_x;cur_x++){
					baechuBat[cur_y][cur_x] = 0;
					visit[cur_y][cur_x]=0;
				}
			}

			int countBaechu = Integer.parseInt(st.nextToken()); // 심는 배추 개수
			for (int j =0;j<countBaechu;j++){
				st = new StringTokenizer(br.readLine());
				int baechu_y =Integer.parseInt(st.nextToken());
				int baechu_x =Integer.parseInt(st.nextToken());
				baechuBat[baechu_y][baechu_x] = 1;
			}
			int needBaechuBug = 0;
			int[] dy={0,-1,0,1};
			int[] dx={1,0,-1,0};
			Queue<Point> queue = new LinkedList<>();

			for(int cur_y = 0;cur_y<max_y;cur_y++){
				for(int cur_x=0;cur_x<max_x;cur_x++){
					if(baechuBat[cur_y][cur_x]==1 && visit[cur_y][cur_x]==0){
						// 방문했다는것을 
						needBaechuBug++;
						// System.out.println(cur_y + ", " + cur_x + "에서 벌레 추가");
						queue.offer(new Point(cur_x,cur_y));
						visit[cur_y][cur_x] = 1;
						// 탐색 로직 추가해야함
						while(!queue.isEmpty()){
							// 큐에서 좌표 꺼내기
							Point current = queue.poll();
							int x = current.x;
							int y = current.y;
							for(int d=0;d<4;d++){
								int new_y = y+dy[d];
								int new_x = x+dx[d];
								if (new_x >=0 && new_x < max_x 
									&& new_y >=0 && new_y < max_y 
									&& baechuBat[new_y][new_x] == 1 
									&& visit[new_y][new_x] == 0){
										queue.offer(new Point(new_x,new_y));
										visit[new_y][new_x] = 1;
								}
							}
						}
					}
				}
			}
			sb.append(needBaechuBug).append('\n');
		}
		System.out.println(sb);
	}
}