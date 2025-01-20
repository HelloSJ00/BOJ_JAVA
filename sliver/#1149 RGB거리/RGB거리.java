import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] house = new int[N][3];
		for(int i = 0 ; i < N ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			house[i][0] = r; 
			house[i][1] = g; 
			house[i][2] = b; 
		}

		Solution(N, house);
	}

	public static void Solution(int N , int[][] house){
		int[] dp = new int[N];
		for(int i = 0 ; i < N ; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		int[] minR = new int[N];
		int[] minG = new int[N];
		int[] minB = new int[N];
		minR[0] = house[0][0];
		minG[0] = house[0][1];
		minB[0] = house[0][2];
		
		for(int i = 1 ; i < N ; i++){
			minR[i] = house[i][0] + Math.min(minG[i-1],minB[i-1]);
			minG[i] = house[i][1] + Math.min(minR[i-1],minB[i-1]);
			minB[i] = house[i][2] + Math.min(minR[i-1],minG[i-1]);
			dp[i] = Math.min(minR[i],Math.min(minG[i],minB[i]));
		}

		System.out.print(dp[N-1]);
	}
}