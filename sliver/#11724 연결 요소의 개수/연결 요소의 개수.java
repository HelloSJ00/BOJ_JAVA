import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adjcantList = new ArrayList[N+1];
		// 배열의 각 요소 초기화
		for (int i = 0; i <= N; i++) {
			adjcantList[i] = new ArrayList<>();
		}

		for (int i = 0; i< M ; i++){
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjcantList[v1].add(v2);
			adjcantList[v2].add(v1);
		}

		System.out.print(Solution(N,M,adjcantList));
	}

	public static int Solution(int N,int M,List<Integer>[] adjcantList){
		int[] visit = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;

		for(int i = 1; i <= N;i++){
			if(visit[i] == 0){
				q.add(i);
				visit[i] = 1;
				while(!q.isEmpty()){
					int cur = q.poll();
					for(int nextVertex : adjcantList[cur]){
						if(visit[nextVertex] == 0){
							visit[nextVertex] = 1;
							q.add(nextVertex);
						}
					}
				}
				answer ++;
			}
		}
		return answer;
	}
}