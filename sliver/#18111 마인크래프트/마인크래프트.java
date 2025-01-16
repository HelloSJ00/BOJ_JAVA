import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int inven = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for(int i = 0; i < N ; i++){
			String[] tmp = br.readLine().split(" ");
			for(int j = 0 ; j < M;j++){
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		Solution(N,M,inven,map);

	}

	public static void Solution(int N,int M,int inven,int[][] map){
		int[] arr = new int[257];

		for(int height = 0 ; height <= 256 ; height++){
			int tmpTime = 0;
			int tmpInven = inven;
			for(int i = 0; i < N ; i++){
				for(int j = 0 ; j < M;j++){
					if( map[i][j] - height >= 0 ){
						tmpTime += (2*(map[i][j] - height));
						tmpInven += map[i][j] - height;
					} else{
						tmpTime += (-(map[i][j] - height));
						tmpInven -= (-(map[i][j] - height));
					}
				}
			}

			if(tmpInven >= 0 ){
				arr[height] = tmpTime;
			} else{
				arr[height] = -1;
			}
		}
		// System.out.println(Arrays.toString(arr));
		int answerFloor = 0;
		int answerTime = Integer.MAX_VALUE;
		for(int height = 0 ; height <= 256 ; height++){
			if(arr[height] != -1 && arr[height] <= answerTime){
				answerTime = arr[height];
				answerFloor = height;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answerTime).append(" ").append(answerFloor);

		System.out.println(sb);
	}
}