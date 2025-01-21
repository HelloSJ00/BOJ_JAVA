import java.io.*;
import java.util.*;

public class Main{
	static List<List<Integer[]>> streets = new ArrayList<>();
	static int N;
	static int M;
	static int X;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int[] toX = new int[N+1];
		int[] xToOwn = new int[N+1];

		for(int i = 0 ; i <= M ; i++){
			streets.add(new ArrayList<>());
		}

		for(int i = 0 ; i < M ; i ++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			streets.get(s).add(new Integer[]{dest,weight});
		}

		for(int i = 1 ; i <= N ; i++){
			toX[i] = dijkstra(i,X);
			xToOwn[i] = dijkstra(X,i);
		}

		int answerValue = toX[1] + xToOwn[1];
		for(int i = 2 ; i <= N ; i++){
			int newValue =  toX[i] + xToOwn[i];
			if(answerValue < newValue){
				answerValue = newValue;
			}
		}
		System.out.print(answerValue);
	}

	public static int dijkstra(int a, int b){
		int[] distance = new int[N+1];
		for(int i = 1 ; i <= N ; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		distance[a] = 0;

		// {정점, 가중치}
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr->arr[1]));
		pq.add(new int[]{a,0});

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int cv = cur[0];
			int cw = cur[1];

			for(Integer[] next : streets.get(cv)){
				int nw = cw + next[1];
				if(nw < distance[next[0]]){
					distance[next[0]] = nw;
					pq.add(new int[]{next[0],nw});
				}
			}
		}
		return distance[b];
	}
}