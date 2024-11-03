import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer TestCase = Integer.parseInt(st.nextToken());

		int[][] dp = new int[41][2];

		dp[0][0]=1;
		dp[0][1]=0;
		dp[1][0]=0;
		dp[1][1]=1;

		// 동적 프로그래밍으로 각 n에 대한 0과 1의 개수 계산
		for (int i = 2; i < 41; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
	}

		for(int j=0;j<TestCase;j++){
			int a =Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			sb.append(dp[a][0]).append(' ').append(dp[a][1]).append('\n');
		}
		System.out.println(sb);
	}
}