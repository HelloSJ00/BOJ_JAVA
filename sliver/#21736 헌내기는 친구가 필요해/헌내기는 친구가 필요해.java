import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[][] map = new String[N][M];
		for(int i = 0 ; i < N ; i++){
			String[] tmp = br.readLine().split("");
			for(int j = 0 ; j < M ; j++){
				map[i][j] = tmp[j];
			}
		}

		Solution(N,M,map);
	}

	static void Solution(int N,int M,String[][] map){
		int[][] visit = new int[N][M];
		int[] dy = new int[]{-1,0,1,0};
		int[] dx = new int[]{0,-1,0,1};

		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < M ; j++){
				if(map[i][j].equals("I")){
					q.add(new int[]{i,j});
					visit[i][j] = 1;
				}
			}
		}
		int answer = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];

			for(int i = 0; i<4; i++){
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(ny >= 0 && ny < N && nx >=0 && nx < M && visit[ny][nx] == 0 && !map[ny][nx].equals("X")){
					if(map[ny][nx].equals("P")) answer++;
					q.add(new int[]{ny,nx});
					visit[ny][nx] = 1;
				}
			}
		}
		if ( answer > 0 ) System.out.print(answer);
		else System.out.print("TT");
	}
}