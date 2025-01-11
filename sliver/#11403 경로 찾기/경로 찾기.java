import java.io.*;
import java.util.*;

public  class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N+1][N+1];
		for(int i = 1; i <= N ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N; j++){
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		Solution(N,map);
	}
	public static void Solution(int N,int[][] map){
		Queue<Integer> q = new LinkedList<>();
		int[][] answer = new int[N+1][N+1];

		for(int i = 1 ; i <= N;i ++){
			q.add(i);

			while(!q.isEmpty()){
				int cur = q.poll();

				for(int j = 1; j <= N; j++){
					if(answer[i][j] == 0 && map[cur][j] == 1){
						answer[i][j] = 1;
						q.add(j);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<= N;i++){
			for(int j = 1; j<= N; j++){
				sb.append(answer[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}
}