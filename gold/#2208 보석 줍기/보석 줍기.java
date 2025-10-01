import java.io.*;
import java.util.*;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int answer = 0;
		int[] arr = new int[N+1];
		for(int i = 1;  i <= N; i++){
			arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
			if(i >= M){
				answer = Math.max(answer,arr[i]);
			}
		}

		for(int i = 2 ; i <= N-M ; i++){
			for(int j = i ; j <= N ; j++){
				if(j-i +1>= M){
					answer = Math.max(answer,arr[j]-arr[i-1]);
				}
			}
		}
		System.out.println(answer);
	}
}