import java.io.*;
import java.util.*;

public class Main{
	static List<List<Integer[]>> tree = new ArrayList<>();
	static int N;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for(int i = 0 ; i <= N ; i++){
			tree.add(new ArrayList<>());
		}

		for(int i = 0 ; i < N ; i ++){
			st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			while(next != -1){
				int dist = Integer.parseInt(st.nextToken());
				tree.get(vertex).add(new Integer[]{next,dist});
				next = Integer.parseInt(st.nextToken());
			}
		}

		int[] firstDistance = dijkstra(1);
		int max = 0;
		for(int i = 1 ; i < firstDistance.length ; i ++){
			if(firstDistance[i] > firstDistance[max] ){
				max = i ;
			}
		}

		int[] seconedDistance = dijkstra(max);
		max = 0;
		for(int i = 1 ; i < seconedDistance.length ; i ++){
			if(seconedDistance[i] > seconedDistance[max] ){
				max = i ;
			}
		}

		System.out.print(seconedDistance[max]);
	}

	public static int[] dijkstra(int start){
		int[] distance = new int[N+1];
		for(int i = 1 ; i <= N ; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);

		while(!pq.isEmpty()){
			int cur = pq.poll();

			for(Integer[] next : tree.get(cur)){
				int nextVertex = next[0];
				int weight = next[1];
				if(distance[cur]+weight < distance[nextVertex]){
					distance[nextVertex] = distance[cur]+weight;
					pq.add(nextVertex);
				}
			}
		}

		return distance;

	}
}