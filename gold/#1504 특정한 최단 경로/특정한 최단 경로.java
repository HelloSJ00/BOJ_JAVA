import java.io.*;
import java.util.*;

public class Main{
	static int N = 0;
	static int M = 0;
	static List<List<int[]>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i <= N ; i++){
			graph.add(new ArrayList<>());
		}

		for(int i = 0 ; i < M ; i ++){
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(src).add(new int[]{next,weight});
			graph.get(next).add(new int[]{src,weight});
		}

		st = new StringTokenizer(br.readLine());
		int mustHave1 =Integer.parseInt(st.nextToken());
		int mustHave2 =Integer.parseInt(st.nextToken());

		int tmp1 = dijkstra(1, mustHave1);
		int tmp2 = dijkstra(mustHave1, mustHave2);
		int tmp3 = dijkstra(mustHave2, N);

		int tmp4 = dijkstra(1, mustHave2);
		int tmp5 = dijkstra(mustHave2, mustHave1);
		int tmp6 = dijkstra(mustHave1, N);

		int answer1 = 0 ;
		int answer2 = 0 ;
		if(tmp1 == -1 || tmp2 == -1 || tmp3 == -1 ){
			answer1 = -1;
		} else{
			answer1 = tmp1+tmp2+tmp3;
		}

		if(tmp4 == -1 || tmp5 == -1 || tmp6 == -1 ){
			answer2 = -1;
		} else{
			answer2 =tmp4+tmp5+tmp6;
		}

		if(answer1 == -1 && answer2 == -1){
			System.out.print(-1);
		} else if(answer1 == -1){
			System.out.print(answer2);
		} else if (answer2 == -1){
			System.out.print(answer1);
		} else{
			System.out.print(Math.min(answer1,answer2));
		}
	}

	public static int dijkstra(int src , int dest){
		int[] distance = new int[N+1];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[src] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr->arr[1]));  
		pq.add(new int[]{src,distance[src]});

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int curSrc = cur[0];
			int curDistance = cur[1];

			for(int[] next : graph.get(curSrc)){
				if(curDistance + next[1] < distance[next[0]]){
					distance[next[0]] = curDistance + next[1] ;
					pq.add(new int[]{next[0],distance[next[0]]});
				}
			}
		}

		if(distance[dest] == Integer.MAX_VALUE) return -1;
		return distance[dest];
	}
}