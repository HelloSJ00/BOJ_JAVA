import java.io.*;
import java.util.*;

public class Main{

	static int[] answer = new int[]{0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 색종이
		int[][] map = new int[N+1][N+1];

		// 색종이 Input 처리
		for (int i = 1;i <= N ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Solution(map, N);
		System.out.println(answer[0]);
		System.out.print(answer[1]);
	}

	public static void Solution(int[][] map,int N){
		int tmp = recru(map,1,1,N);
		if ( tmp== 0 ) answer[0]++;
		else if (tmp == 1) answer[1]++;
		}

	public static int recru(int[][] map,int Y,int X,int L){
		if( L == 1){
			if(map[Y][X] == 1) return 1;
			else return 0;
		}

		int white = 0;
		int blue = 0;

		int[] tmp_result = new int[4];
		int[] dy = new int[]{0,L/2,0,L/2};
		int[] dx = new int[]{0,0,L/2,L/2};
		for ( int i = 0; i < 4 ; i ++){
			tmp_result[i] = recru(map,Y+dy[i],X+dx[i],L/2);
		}

		for (int i = 0 ; i < 4 ; i++){
			if (tmp_result[i] == 1)  blue ++;
			else if (tmp_result[i] == 0) white ++;
		}

		if (blue == 4) return 1;
		else if (white == 4) return 0;
		else{
			answer[0] += white;
			answer[1] += blue;
			return 2;
		}
	}
}