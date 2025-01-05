import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args ) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[N];
		for(int i = 0 ; i < N ; i++){
			arr[i] = Long.parseLong(st.nextToken());
		}

		Solution(N,arr);
	}

	public static void Solution(int N , long[] arr){
		long[] dp = new long[N];
		long[] sortArr = Arrays.copyOf(arr,arr.length);

		Arrays.sort(sortArr);
		Map<Long,Long> map = new HashMap<>();
		dp[0]= 0;
		map.put(sortArr[0],0L);

		for(int i = 1; i < N; i++){
			if(sortArr[i] > sortArr[i-1]){
				dp[i] = dp[i-1]+1;
			} else{
				dp[i] = dp[i-1];
			}
			map.put(sortArr[i],dp[i]);
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< N; i++){
			sb.append(map.get(arr[i])).append(' ');
		}

		System.out.print(sb);
	}
}