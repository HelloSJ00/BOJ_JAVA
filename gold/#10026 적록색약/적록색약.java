import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args ) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[][] map = new String[N+1][N+1];

		for(int i = 1 ; i <= N ; i++){
			String[] st = br.readLine().split("");
			for(int j = 1;j <= N ; j++){
				map[i][j] = st[j-1];
			}
		}
		Solution(N,map);
	}

	public static void Solution(int N,String[][] map){
		// System.out.println(Arrays.deepToString(map));
		int[] dy = new int[]{-1,0,1,0};
		int[] dx = new int[]{0,-1,0,1};
		// 정상인이 봤을때 구역의 개수
		int nCnt = 0;
		// 적녹색약이 봤을때 구역의 개수
		int abCnt = 0;

		int[][] visit = new int[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();

		for(int i = 1 ; i <= N ; i++){
			for(int j = 1;j <= N ; j++){
				if(visit[i][j] == 0){
					nCnt++;
					q.add(new int[]{i,j});
					visit[i][j] = 1;

					while(!q.isEmpty()){
						int[] cur = q.poll();
						int cy = cur[0];
						int cx = cur[1];
	
						for(int k = 0 ; k < 4 ; k++){
							int ny = cy + dy[k];
							int nx = cx + dx[k];
							if( ny > 0 && ny <= N && nx > 0 && nx <= N && visit[ny][nx] == 0 &&
								map[cy][cx].equals(map[ny][nx])	
							){
								visit[ny][nx] =1;
								q.add(new int[]{ny,nx});
							}
						}
					}
				}
				

			}
		}

		// 적녹색약 탐색
		visit = new int[N+1][N+1];
		q = new LinkedList<>();

		for(int i = 1 ; i <= N ; i++){
			for(int j = 1;j <= N ; j++){
				if(visit[i][j] == 0){
					abCnt++;
					q.add(new int[]{i,j});
					visit[i][j] = 1;
					while(!q.isEmpty()){
						int[] cur = q.poll();
						int cy = cur[0];
						int cx = cur[1];

						for(int k = 0 ; k< 4 ; k++){
							int ny = cy + dy[k];
							int nx = cx + dx[k];
							if( ny > 0 && ny <= N && nx > 0 && nx <= N && visit[ny][nx] == 0 &&
								((map[cy][cx].equals(map[ny][nx]) || (map[cy][cx].equals("R") && map[ny][nx].equals("G"))) ||
								(map[cy][cx].equals("G") && map[ny][nx].equals("R"))))
							{
								visit[ny][nx] =1;
								q.add(new int[]{ny,nx});
							}
						}
					}
				}
			}
		}
		System.out.print(nCnt+" "+ abCnt);
		}
	}
