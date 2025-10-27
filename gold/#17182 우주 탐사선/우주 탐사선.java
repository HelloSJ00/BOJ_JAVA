import java.io.*;
import java.util.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N; j++){
				for(int k = 0 ; k < N ; k++){
					map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);
				}
			}
		}

		visit = new boolean[N];
		visit[s] = true;
		recur(s,0,1);


		System.out.println(answer);
	}

	static void recur(int prev,int dist,int depth){
		if(depth == N){
			answer = Math.min(answer,dist);
			return;
		}

		for(int i = 0 ; i < N ; i++){
			if(!visit[i]){
				visit[i] = true;
				recur(i,dist+map[prev][i],depth+1);
				visit[i] = false;
			}
		}
	}
}