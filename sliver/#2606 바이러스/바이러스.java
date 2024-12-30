import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] arr = new ArrayList[N+1];

		// 배열의 각 요소를 초기화
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < K;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		System.out.print(Solution(arr,N,K));
	}

	public static int Solution(ArrayList<Integer>[] arr,int N,int K){
		int[] birus = new int[N+1];
		int cnt = 0; 

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while(!queue.isEmpty()){
			int cur = queue.poll();

			for(int next : arr[cur]){
				if (birus[next] != 1 && next != 1){
					birus[next] = 1;
					cnt ++;
					queue.add(next);
				}
			}
		}

		return cnt;
	}
}