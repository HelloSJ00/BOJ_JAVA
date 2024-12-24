import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] Args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[1000001][2];
		for(int i=1;i<dp.length;i++){
			dp[i][0] = i;
			dp[i][1] = Integer.MAX_VALUE;
		}
		dp[1][1]=0;
		Queue<int[]> queue = new LinkedList<>();
		

		queue.add(dp[1]);
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int curIndex = cur[0];
			int curCnt = cur[1];

			if(curIndex+1 < dp.length && dp[curIndex+1][1] > curCnt+1){
				dp[curIndex+1][1] = curCnt+1;
				queue.add(dp[curIndex+1]);
			}
			if(curIndex*2 < dp.length && dp[curIndex*2][1] > curCnt+1){
				dp[curIndex*2][1] = curCnt+1;
				queue.add(dp[curIndex*2]);
			}
			if(curIndex*3 < dp.length && dp[curIndex*3][1] > curCnt+1){
				dp[curIndex*3][1] = curCnt+1;
				queue.add(dp[curIndex*3]);
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append(dp[number][1]);

		System.out.println(sb);
	}
}