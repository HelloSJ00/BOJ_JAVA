import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		for(int i = 1 ; i<= N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Solution(N,M,map);
	}

	public static void Solution(int N,int M,int[][] map){
		Stack<int[]> s = new Stack<>();
		int[] floorValue = new int[5];
		int answer = 0;
		int tmp = 0;

		int[] dy = new int[]{-1,0,1,0};
		int[] dx = new int[]{0,-1,0,1};

		for(int i = 1; i<=N ;i++){
			for(int j = 1 ; j <= M ; j++){
				int[] around = new int[4];
				for(int k = 0; k < 4 ; k++){
					if( i + dy[k] > 0 && j + dx[k] > 0 && i +dy[k] <= N && j + dx[k] <=M){
						around[k] = map[i+dy[k]][j+dx[k]];
					}
				}
				int sum = map[i][j];
				for(int v : around){
					sum += v;
				}

				for(int v: around){
					if( sum - v > answer){
						answer = sum - v;
					}
				}


				s.push(new int[]{i,j,map[i][j],1,0,0});

				while(!s.isEmpty()){
					int[] cur = s.pop();
					int cy = cur[0];
					int cx = cur[1];
					int value  = cur[2];
					int floor = cur[3];
					int prevy = cur[4];
					int prevx = cur[5];
					// 층별 값 변경
					floorValue[floor] = value;
					
					// 4층일때 답 비교 및 최대값으로 교체
					if(floor == 4){
						tmp = 0;
						for(int v:floorValue){
							tmp += v;
						}
						if (tmp > answer){
							answer = tmp;
						}
					} else{
						for(int k = 0 ; k < 4 ; k ++){
							int ny = cy + dy[k];
							int nx = cx + dx[k];
							if(ny > 0 && ny <= N && nx > 0 && nx <= M && !(prevx == nx && prevy == ny) ){
								s.push(new int[]{ny,nx,map[ny][nx],floor+1,cy,cx});
							}
						}
					}
					
				}
			}
		}
		System.out.print(answer);
	}
}