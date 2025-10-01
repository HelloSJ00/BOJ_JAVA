import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static int N;
	static int Q;

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		int[] arr = new int[1_000_001];

		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[1_000_001];
		dp[1] = arr[1];
		for(int i = 2 ; i <= N ; i++){
			dp[i] = dp[i-1]^arr[i];
		}
		int answer = -1;
		for(int i = 0 ; i < Q ; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int tmp = dp[e]^dp[s-1];
			// System.out.println(tmp);
			if(answer == -1){
				answer = tmp;
			} else {
				answer = answer^tmp;
			}
		}
		System.out.println(answer);
	}

}