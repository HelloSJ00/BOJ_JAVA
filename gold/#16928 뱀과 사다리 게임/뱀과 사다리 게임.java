import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer,Integer> jump = new HashMap<>();
		Map<Integer,Integer> back = new HashMap<>();

		for(int i = 0 ; i < N ;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			jump.put(a,dest);
		}
		for(int i = 0 ; i < M ;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			back.put(a,dest);
		}

		Solution(jump,back);
	}

	public static void Solution(Map<Integer,Integer> jump,Map<Integer,Integer> back){
		int[] dp = new int[101];
		int[] check = new int[101];

		for(int i = 2 ; i <= 100 ; i++){
			dp[i] = Integer.MAX_VALUE;
		}

		dp[1] =0;
		for( int i = 2 ; i <= 6 ; i++){
			dp[i] = 1;
			if(jump.containsKey(i)){
				dp[jump.get(i)] = 1;
			}
		}
		int cur = 7;
		while(cur != 101){
			for (int i = 1; i <= 6 ; i++){
				if(check[cur-i] != 1) dp[cur] = Math.min(dp[cur],dp[cur-i]+1);
			}

			if(jump.containsKey(cur)) dp[jump.get(cur)] = Math.min(dp[jump.get(cur)] ,dp[cur]);
			else if(back.containsKey(cur)){
				check[cur] = 1;
				if (dp[back.get(cur)] > dp[cur]){
					dp[back.get(cur)] = dp[cur];
					cur = back.get(cur);
					continue;
				}
			}
			cur++;
		}
		// System.out.println(Arrays.toString(dp));
		System.out.print(dp[100]);
	}
}
