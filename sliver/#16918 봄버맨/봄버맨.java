import java.util.*;
import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int time = 1;
	static boolean[][] 폭탄;
	static int[][] timer;
	static int R;
	static int C;
	static int N;

	static public void main(String[] args) throws Exception{	
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		폭탄 = new boolean[R][C];
		timer = new int[R][C];

		for(int i = 0 ; i < R ; i++){
			String c = br.readLine();
			for(int j = 0 ; j < C ; j++){
				char tmp = c.charAt(j);
				if(tmp == 'O'){
					폭탄[i][j] = true;
					timer[i][j] = 0;
				}
			}
		}

		while(time < N){
			time++;
			// System.out.println(time);
			if(time%2 == 0){
				폭탄설치();
			} else if(time%2 == 1){
				폭탄_터트리기();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < R ; i++){
			for(int j = 0 ; j < C ; j++){
				if(폭탄[i][j]){
					sb.append("O");
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void 폭탄설치(){
		for(int i = 0 ; i < R ; i++){
			for(int j = 0 ; j < C ; j++){
				if(!폭탄[i][j]){
					폭탄[i][j] = true;
					timer[i][j] = time;
				}
			}
		}
	}

	static void 폭탄_터트리기(){

		Deque<int[]> q = new ArrayDeque<>();

		for(int i = 0 ; i < R ; i++){
			for(int j = 0 ; j < C ; j++){
				if(폭탄[i][j] && timer[i][j] == time-3){
					q.offer(new int[]{i,j});
				}
			}
		}

		while(!q.isEmpty()){
			int[] cur = q.poll();
			bang(cur[0],cur[1]);
		}
	}

	static void bang(int y,int x){
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,1,-1};

		for(int i = 0 ; i < 4 ; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny >= 0 && ny < R && nx >= 0 && nx < C){
				폭탄[ny][nx] = false;
				timer[ny][nx] = 0;
			}
		}

		폭탄[y][x] = false;
		timer[y][x] = 0;
	}

}
