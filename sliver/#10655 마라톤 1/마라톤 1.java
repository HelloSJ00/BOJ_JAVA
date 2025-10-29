import java.util.*;
import java.io.*;

public class Main{
	static public void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] cp = new int[N][2];

		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			cp[i] = new int[]{y,x};
		}

		int[] backDist = new int[N];
		int[] goDist = new int[N];

		for(int i = 1 ; i < N ; i++){
			int newDistY = cp[i-1][0] - cp[i][0] > 0 ? cp[i-1][0] - cp[i][0] : -(cp[i-1][0] - cp[i][0]);
			int newDistX = cp[i-1][1] - cp[i][1] > 0 ? cp[i-1][1] - cp[i][1] : -(cp[i-1][1] - cp[i][1]);
			backDist[i] = backDist[i-1] + newDistY + newDistX;
		}

		for(int i = N-2 ; i >= 0 ; i--){
			int newDistY = cp[i+1][0] - cp[i][0] > 0 ? cp[i+1][0] - cp[i][0] : -(cp[i+1][0] - cp[i][0]);
			int newDistX = cp[i+1][1] - cp[i][1] > 0 ? cp[i+1][1] - cp[i][1] : -(cp[i+1][1] - cp[i][1]);
			goDist[i] = goDist[i+1] + newDistY + newDistX;
		}

		// System.out.println(Arrays.toString(backDist));
		// System.out.println(Arrays.toString(goDist));
		int answer = Integer.MAX_VALUE;
		for(int i = 1 ; i < N-1 ; i++){
			int newDistY = cp[i-1][0] - cp[i+1][0] > 0 ? cp[i-1][0] - cp[i+1][0] : -(cp[i-1][0] - cp[i+1][0]);
			int newDistX = cp[i-1][1] - cp[i+1][1] > 0 ? cp[i-1][1] - cp[i+1][1] : -(cp[i-1][1] - cp[i+1][1]);
			answer = Math.min(answer,backDist[i-1] + goDist[i+1] + newDistY+newDistX);
		}
		System.out.println(answer);
	}	
}